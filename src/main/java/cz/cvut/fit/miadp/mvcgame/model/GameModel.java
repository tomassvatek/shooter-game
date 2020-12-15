package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectFactory_B;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCmd;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.prototype.IPrototype;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.enemy.RealisticEnemyMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.missile.RealisticMissileMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.missile.SimpleMissileMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class GameModel implements IGameModel {

    private AbsGameInfo gameInfo;
    private AbsCannon cannon;

    private List<AbsMissile> missiles;
    private List<AbsEnemy> enemies;
    private List<AbsCollision> collisions;

    private int score;

    private List<IObserver> observers;
    private IGameObjectFactory gameObjectFactory;
    private IMovingStrategy<AbsMissile> activeMissileMovingStrategy;
    private IMovingStrategy<AbsEnemy> activeEnemyMovingStrategy;

    private Stack<AbstractGameCmd> executedCmd = new Stack<>();
    private Queue<AbstractGameCmd> unExecutedCmd = new LinkedBlockingQueue<>();

    public GameModel() {
        this.activeMissileMovingStrategy = new SimpleMissileMovingStrategy();
        this.activeEnemyMovingStrategy = new RealisticEnemyMovingStrategy();

        this.gameObjectFactory = new GameObjectFactory_B(this);

        this.cannon = this.gameObjectFactory.createCannon();
        this.missiles = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.collisions = new ArrayList<>();

        this.score = 0;

        this.gameInfo = this.gameObjectFactory.createGameInfo(this.getGameInfoText());

        this.observers = new ArrayList<>();
    }

    public Position getCannonPosition() {
        return cannon.getPosition();
    }

    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();

        gameObjects.add(this.gameInfo);
        gameObjects.add(this.cannon);
        gameObjects.addAll(this.missiles);
        gameObjects.addAll(this.enemies);
        gameObjects.addAll(this.collisions);

        return gameObjects;
    }

    public void moveCannonUp() {
        cannon.moveUp();
        this.notifyObservers();
    }

    public void moveCannonDown() {
        cannon.moveDown();
        this.notifyObservers();
    }

    public void cannonShoot() {
        this.missiles.addAll(cannon.shoot());
        this.notifyObservers();
    }

    public void timeTick() {
        this.update();
    }

    public void update() {
        this.executeCmds();
        this.moveMissiles();
        this.moveEnemies();

        this.checkCollisions();
        this.generateEnemies();

        this.refreshGameInfo();
    }

    private void executeCmds() {
        while (!this.unExecutedCmd.isEmpty()) {
            AbstractGameCmd cmd = unExecutedCmd.poll();
            cmd.doExecute();

            this.executedCmd.push(cmd);
        }
    }

    private void moveMissiles() {
        for (AbsMissile missile : this.missiles) {
            missile.move();
        }

        this.destroyMissiles();
        this.notifyObservers();
    }

    private void destroyMissiles() {
        List<AbsMissile> toRemove = new ArrayList<>();
        for (AbsMissile missile : this.missiles) {
            if (missile.getPosition().getX() > MvcGameConfig.MAX_X) {
                toRemove.add(missile);
            }
        }
        this.missiles.removeAll(toRemove);
    }

    private void moveEnemies() {
        for (AbsEnemy enemy : this.enemies) {
            enemy.move();
        }

        this.notifyObservers();
    }

    private void checkCollisions() {
        for (AbsMissile missile : this.missiles) {
            for (AbsEnemy enemy : this.enemies) {
                if (enemy.getPosition().isInRadius(missile.getPosition())) {
                    this.enemies.remove(enemy);

                    Position collisionPos = new Position(enemy.getPosition().getX(), enemy.getPosition().getY());
                    this.collisions.add(this.gameObjectFactory.createCollision(collisionPos));

                    this.incrementScore(enemy);
                    break;
                }
            }
        }

        this.destroyCollisions();
        this.notifyObservers();
    }

    private void refreshGameInfo() {
        this.gameInfo.setText(this.getGameInfoText());
        this.notifyObservers();
    }

    private void destroyCollisions() {
        if (this.collisions.size() == 0) return;

        List<AbsCollision> remove = this.collisions.stream().filter(c -> c.getAge() > 1).collect(Collectors.toList());
        this.collisions.removeAll(remove);
    }

    // TODO: Extend more strategies, strategies should be toggleable from the UI
    public void toggleMovingStrategy() {
        if (this.activeMissileMovingStrategy instanceof SimpleMissileMovingStrategy) {
            this.activeMissileMovingStrategy = new RealisticMissileMovingStrategy();
        } else if (this.activeMissileMovingStrategy instanceof RealisticMissileMovingStrategy) {
            this.activeMissileMovingStrategy = new SimpleMissileMovingStrategy();
        }
    }

    public void toggleShootingMode() {
        this.cannon.toggleShootingMode();
    }

    public void aimCannonUp() {
        this.cannon.aimUp();
    }

    public void aimCannonDown() {
        this.cannon.aimDown();
        this.notifyObservers();
    }

    public void cannonPowerUp() {
        this.cannon.powerUp();
        this.notifyObservers();
    }

    public void cannonPowerDown() {
        this.cannon.powerDown();
    }

    @Override
    public IMovingStrategy<AbsMissile> getMissileMovingStrategy() {
        return this.activeMissileMovingStrategy;
    }

    @Override
    public IMovingStrategy<AbsEnemy> getEnemyMovingStrategy() {
        return this.activeEnemyMovingStrategy;
    }

    @Override
    public String getShootingModeName() {
        return this.cannon.getShootingMode();
    }

    @Override
    public void registerCommand(AbstractGameCmd command) {
        this.unExecutedCmd.add(command);
    }

    @Override
    public void undoLastCommand() {
        if (this.executedCmd.isEmpty())
            return;

        AbstractGameCmd lastCmd = this.executedCmd.pop();
        lastCmd.unExecute();

        this.notifyObservers();
    }

    @Override
    public void generateEnemies() {
        int missingEnemies = MvcGameConfig.MAX_ENEMIES - this.enemies.size();

        for (int i = 0; i < missingEnemies; i++) {
            if (i % 2 == 0)
                this.enemies.add(this.gameObjectFactory.createEnemy());
            else
                this.enemies.add(this.gameObjectFactory.createAdvanceEnemy());
        }

        this.notifyObservers();
    }

    @Override
    public void register(IObserver observer) {
        if (!observers.contains(observer)) {
            this.observers.add(observer);
        }
    }

    @Override
    public void unRegister(IObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (IObserver obs : this.observers) {
            obs.update();
        }
    }

    private class Memento {
        private AbsCannon cannon;
        private AbsGameInfo gameInfo;

        private List<AbsMissile> missiles;
        private List<AbsEnemy> enemies;
        private List<AbsCollision> collisions;

        private int score;
    }

    //TODO: These two methods are same! There are not same, the first one has not parameter
    public Object createMemento() {
        Memento m = new Memento();

        m.score = this.score;
        m.cannon = this.cannon.clone();
        m.gameInfo = this.gameInfo.clone();

        m.missiles = this.cloneCollection(this.missiles);
        m.enemies = this.cloneCollection(this.enemies);
        m.collisions = this.cloneCollection(this.collisions);

        return m;
    }

    public void setMemento(Object memento) {
        Memento m = (Memento) memento;

        this.score = m.score;
        this.cannon = m.cannon.clone();
        this.gameInfo = m.gameInfo.clone();

        this.missiles = this.cloneCollection(m.missiles);
        this.enemies = this.cloneCollection(m.enemies);
        this.collisions = this.cloneCollection(m.collisions);
    }

    private <T extends IPrototype> List<T> cloneCollection(List<T> prototypes) {
        List<T> clones = new ArrayList<>();
        for (IPrototype prototype : prototypes) {
            clones.add((T) prototype);
        }
        return clones;
    }

    private void incrementScore(AbsEnemy enemy) {
        this.score += enemy.getBonus();
    }

    private String getGameInfoText() {
        return "Score: " + this.score + ", " + "Angle: " + this.cannon.getAngle() + ", " + "Power: "
                + this.cannon.getPower() + ", " + "Shooting mode: " + this.cannon.getShootingMode()
                + ", " + "Missile moving mode: " + this.activeMissileMovingStrategy.getClass().getName();
    }

}

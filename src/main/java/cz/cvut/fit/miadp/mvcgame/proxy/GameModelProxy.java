package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCmd;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.List;

public class GameModelProxy implements IGameModel {
    private final IGameModel model;

    public GameModelProxy(IGameModel gameModel) {
        this.model = gameModel;
    }

    @Override
    public Position getCannonPosition() {
        return this.model.getCannonPosition();
    }

    @Override
    public void update() {
        this.model.update();
    }

    @Override
    public void moveCannonUp() {
        this.model.moveCannonUp();
    }

    @Override
    public void moveCannonDown() {
        this.model.moveCannonDown();
    }

    @Override
    public void cannonShoot() {
        this.model.cannonShoot();
    }

    @Override
    public void aimCannonUp() {
        this.model.aimCannonUp();
    }

    @Override
    public void aimCannonDown() {
        this.model.aimCannonDown();
    }

    @Override
    public void cannonPowerUp() {
        this.model.cannonPowerUp();
    }

    @Override
    public void cannonPowerDown() {
        this.model.cannonPowerDown();
    }

    @Override
    public void toggleMovingStrategy() {
        this.model.toggleMovingStrategy();
    }

    @Override
    public void toggleShootingMode() {
        this.model.toggleShootingMode();
    }

    @Override
    public List<GameObject> getGameObjects() {
        return this.model.getGameObjects();
    }

    @Override
    public void register(IObserver observer) {
        this.model.register(observer);
    }

    @Override
    public void unRegister(IObserver observer) {
        this.model.unRegister(observer);
    }

    @Override
    public void notifyObservers() {
        this.model.notifyObservers();
    }

    @Override
    public Object createMemento() {
        return this.model.createMemento();
    }

    @Override
    public void setMemento(Object memento) {
        this.model.setMemento(memento);
    }

    @Override
    public void timeTick() {
        this.model.timeTick();
    }

    @Override
    public IMovingStrategy<AbsMissile> getMissileMovingStrategy() {
        return this.model.getMissileMovingStrategy();
    }
    public IMovingStrategy<AbsEnemy> getEnemyMovingStrategy() {
        return this.model.getEnemyMovingStrategy();
    }

    @Override
    public String getShootingModeName() {
        return model.getShootingModeName();
    }

    @Override
    public void registerCommand(AbstractGameCmd command) {
        this.model.registerCommand(command);
    }

    @Override
    public void undoLastCommand() {
        this.model.undoLastCommand();
    }

    @Override
    public void generateEnemies() {
        this.model.generateEnemies();
    }
}

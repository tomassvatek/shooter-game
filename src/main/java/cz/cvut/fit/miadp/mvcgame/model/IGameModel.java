package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCmd;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.List;

public interface IGameModel extends IObservable {
    Position getCannonPosition();

    void update();

    void moveCannonUp();

    void moveCannonDown();

    void cannonShoot();

    void aimCannonUp();

    void aimCannonDown();

    void cannonPowerUp();

    void cannonPowerDown();

    void toggleMovingStrategy();

    void toggleShootingMode();

    List<GameObject> getGameObjects();

    void register(IObserver observer);

    Object createMemento();

    void setMemento(Object memento);

    void timeTick();

    IMovingStrategy<AbsMissile> getMissileMovingStrategy();

    IMovingStrategy<AbsEnemy> getEnemyMovingStrategy();

    String getShootingModeName();

    void registerCommand(AbstractGameCmd command);

    void undoLastCommand();

    void generateEnemies();
}

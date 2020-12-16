package cz.cvut.fit.miadp.mvcgame.strategy;

public interface IMovingStrategy<T extends IMovable> {
    void updatePosition(T movable);
    String getName();
}

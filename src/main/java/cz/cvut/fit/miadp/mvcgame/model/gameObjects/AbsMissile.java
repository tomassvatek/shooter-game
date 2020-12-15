package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.prototype.IPrototype;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovable;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsMissile extends LifetimeLimitedGameObject implements IPrototype<AbsMissile>, IMovable {
    protected IMovingStrategy<AbsMissile> movingStrategy;
    protected double initAngle;
    protected int initVelocity;

    public AbsMissile(Position position, double initAngle, int initVelocity) {
        super(position);
        this.initAngle = initAngle;
        this.initVelocity = initVelocity;
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitMissile(this);
    }

    public int getInitVelocity() {
        return this.initVelocity;
    }

    public double getInitAngle() {
        return initAngle;
    }

    @Override
    public abstract void move();

    @Override
    public abstract AbsMissile clone();
}

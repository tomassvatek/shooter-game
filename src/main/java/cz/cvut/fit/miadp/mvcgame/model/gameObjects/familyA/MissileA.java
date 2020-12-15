package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class MissileA extends AbsMissile {

    public MissileA(Position position, double initAngle, int initVelocity, IMovingStrategy<AbsMissile> movingStrategy) {
        super(position, initAngle, initVelocity);
        this.movingStrategy = movingStrategy;
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitMissile(this);
    }

    @Override
    public void move() {
        this.movingStrategy.updatePosition(this);
    }

    @Override
    public AbsMissile clone() {
        return new MissileA(this.position.clone(), this.getInitAngle(), this.getInitVelocity(), this.movingStrategy);
    }
}

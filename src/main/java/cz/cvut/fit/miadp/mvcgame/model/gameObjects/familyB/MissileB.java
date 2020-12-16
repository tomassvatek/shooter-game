package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyB;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class MissileB extends AbsMissile {
    public MissileB(Position position, double initAngle, int initVelocity, IMovingStrategy<AbsMissile> movingStrategy) {
        super(position, initAngle, initVelocity);
        this.movingStrategy = movingStrategy;
    }

    @Override
    public void move() {
        this.movingStrategy.updatePosition(this);
    }

    @Override
    public AbsMissile clone() {
        return new MissileB(this.position.clone(), this.getInitAngle(), this.getInitVelocity(), this.movingStrategy);
    }
}

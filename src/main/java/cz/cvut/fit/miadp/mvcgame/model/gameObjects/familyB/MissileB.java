package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyB;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA.MissileA;
import cz.cvut.fit.miadp.mvcgame.strategy.missile.SimpleMissileMovingStrategy;

public class MissileB extends AbsMissile {
    public MissileB(Position position, double initAngle, int initVelocity) {
        super(position, initAngle, initVelocity);
        this.movingStrategy = new SimpleMissileMovingStrategy();
    }

    @Override
    public void move() {
        this.movingStrategy.updatePosition(this);
    }

    @Override
    public AbsMissile clone() {
        return new MissileB(this.position.clone(), this.getInitAngle(), this.getInitVelocity());
    }
}

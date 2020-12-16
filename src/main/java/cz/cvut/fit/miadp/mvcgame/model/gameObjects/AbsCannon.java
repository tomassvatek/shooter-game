package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.prototype.IPrototype;
import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

import java.util.List;

public abstract class AbsCannon extends GameObject implements IPrototype<AbsCannon> {
    protected double angle;
    protected int power;

    protected static IShootingMode SINGLE_SHOOTING_MODE = new SingleShootingMode();
    protected static IShootingMode DOUBLE_SHOOTING_MODE = new DoubleShootingMode();

    public AbsCannon(IShootingMode shootingMode) {
        this.shootingMode = shootingMode;
    }

    protected IShootingMode shootingMode;

    public abstract void moveUp();

    public abstract void moveDown();

    public abstract void primitiveShoot(Vector missileMove);

    public abstract List<AbsMissile> shoot();

    public abstract void powerUp();

    public abstract void powerDown();

    public abstract void aimUp();

    public abstract void aimDown();

    public double getAngle() {
        return this.angle;
    }

    public int getPower() {
        return this.power;
    }

    public String getShootingMode() {
        return this.shootingMode.getName();
    }

    public void toggleShootingMode() {
        if (this.shootingMode instanceof SingleShootingMode) {
            this.shootingMode = DOUBLE_SHOOTING_MODE;
        } else if (this.shootingMode instanceof DoubleShootingMode) {
            this.shootingMode = SINGLE_SHOOTING_MODE;
        }
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitCannon(this);
    }

    @Override
    public abstract AbsCannon clone();
}

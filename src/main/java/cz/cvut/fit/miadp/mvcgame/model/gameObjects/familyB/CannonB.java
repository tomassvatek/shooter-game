package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyB;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class CannonB extends AbsCannon {
    private IGameObjectFactory gameObjectFactory;
    private List<AbsMissile> shootings;

    public CannonB(Position position, IGameObjectFactory gameObjectFactory) {
        super(new DoubleShootingMode());

        this.gameObjectFactory = gameObjectFactory;
        this.position = position;
        this.shootings = new ArrayList<>();
    }

    @Override
    public void moveUp() {
        this.move(new Vector(0, -1 * MvcGameConfig.CannonB_MOVE_STEP));
    }

    @Override
    public void moveDown() {
        this.move((new Vector(0, MvcGameConfig.CannonB_MOVE_STEP)));
    }

    @Override
    public void primitiveShoot(Vector missileMove) {
        this.shootings.add(this.gameObjectFactory.createMissile(new Position(this.position.getX() + missileMove.getDx(),
                        this.position.getY() + missileMove.getDy()),
                this.angle, this.power));
    }

    @Override
    public List<AbsMissile> shoot() {
        this.shootings.clear();

        // use current state to shoot
        this.shootingMode.shoot(this);

        return this.shootings;
    }

    @Override
    public void powerUp() {
        if (this.power + MvcGameConfig.CANNON_POWER_STEP > MvcGameConfig.CANNON_POWER_MAX) return;
        this.power += MvcGameConfig.CANNON_POWER_STEP;
    }

    @Override
    public void powerDown() {
        if (this.power - MvcGameConfig.CANNON_POWER_STEP <= MvcGameConfig.CANNON_POWER_MIN) return;
        this.power -= MvcGameConfig.CANNON_POWER_STEP;
    }

    @Override
    public void aimUp() {
        if (this.angle + MvcGameConfig.ANGLE_STEP <= MvcGameConfig.MAX_ANGLE)
            this.angle += MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public void aimDown() {
        if (this.angle - MvcGameConfig.ANGLE_STEP >= MvcGameConfig.MIN_ANGLE)
            this.angle -= MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public AbsCannon clone() {
        CannonB clone = new CannonB(this.position.clone(), this.gameObjectFactory);

        clone.angle = this.angle;
        clone.power = this.power;
        clone.shootings = this.shootings;
        clone.shootingMode = this.shootingMode;

        return clone;
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitCannon(this);
    }
}

package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class CannonA extends AbsCannon {
    private IGameObjectFactory gameObjectFactory;
    private List<AbsMissile> shootings;

    public CannonA(Position position, IGameObjectFactory gameObjectFactory) {
        // Initialize default shooting mode
        super(new SingleShootingMode());

        this.position = position;
        this.gameObjectFactory = gameObjectFactory;

        this.power = MvcGameConfig.CANNON_INIT_POWER;
        this.angle = MvcGameConfig.INIT_ANGLE;

        this.shootings = new ArrayList<>();
    }

    @Override
    public void moveUp() {
        int newDy = this.position.getY() + (-1 * MvcGameConfig.CannonA_MOVE_STEP);
        if (newDy < MvcGameConfig.MIN_CANNON_POS_Y) return;

        this.move(new Vector(0, -1 * MvcGameConfig.CannonA_MOVE_STEP));
    }

    //TODO: Full-scren is bigger then MAX_CANNON_POS_Y
    @Override
    public void moveDown() {
        int newDy = this.position.getY() + MvcGameConfig.CannonA_MOVE_STEP;
        if (newDy > MvcGameConfig.MAX_CANNON_POS_Y) return;

        this.move((new Vector(0, MvcGameConfig.CannonA_MOVE_STEP)));
    }

    @Override
    public List<AbsMissile> shoot() {
        this.shootings.clear();

        // use current state to shoot
        this.shootingMode.shoot(this);

        return this.shootings;
    }

    @Override
    public void primitiveShoot(Vector missileMove) {
        this.shootings.add(this.gameObjectFactory.createMissile(new Position(this.position.getX() + missileMove.getDx(),
                        this.position.getY() + missileMove.getDy()),
                this.angle, this.power));
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
        if(this.angle - MvcGameConfig.ANGLE_STEP >= MvcGameConfig.MIN_ANGLE)
            this.angle -= MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitCannon(this);
    }

    @Override
    public AbsCannon clone() {
        CannonA clone = new CannonA(this.position.clone(), this.gameObjectFactory);

        clone.angle = this.angle;
        clone.power = this.power;
        clone.shootings = this.shootings;
        clone.shootingMode = this.shootingMode;

        return clone;
    }
}

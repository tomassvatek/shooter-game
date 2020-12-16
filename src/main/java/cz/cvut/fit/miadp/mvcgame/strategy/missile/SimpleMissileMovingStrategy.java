package cz.cvut.fit.miadp.mvcgame.strategy.missile;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class SimpleMissileMovingStrategy implements IMovingStrategy<AbsMissile> {
    @Override
    public void updatePosition(AbsMissile missile) {
        missile.move(new Vector(MvcGameConfig.CannonA_MOVE_STEP, 0));
//        Position pos = mis.getPosition();
//        if (mis.getAngle() == 0) {
//            pos.setX(pos.getX() + 1 * mis.getVelocity());
//        } else if (mis.getAngle() == 90) {
//            pos.setY(pos.getY() - 1 * mis.getVelocity());
//        } else {
//            pos.setX(pos.getX() + 1 * mis.getVelocity());
//            pos.setY(pos.getY() - 1 * mis.getVelocity());
//        }
    }

    @Override
    public String getName() {
        return "Simple";
    }
}

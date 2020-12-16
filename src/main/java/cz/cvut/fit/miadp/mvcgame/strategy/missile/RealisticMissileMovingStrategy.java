package cz.cvut.fit.miadp.mvcgame.strategy.missile;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public class RealisticMissileMovingStrategy implements IMovingStrategy<AbsMissile> {
    @Override
    public void updatePosition(AbsMissile missile) {
        int initVelocity = missile.getInitVelocity();
        double initAngle = missile.getInitAngle();

        long time = missile.getAge();
        if (time == 0)
            time = 1;

        double alphaInRad = (-initAngle) * Math.PI / 180;

        int dX = (int) (initVelocity * time * Math.cos(alphaInRad));
        int dY = (int) (initVelocity * time * Math.sin(alphaInRad) + (1 / 2 * MvcGameConfig.GRAVITY * time * time) / 100F);

        missile.move(new Vector(dX, dY));
    }

    @Override
    public String getName() {
        return "Realistic";
    }

}

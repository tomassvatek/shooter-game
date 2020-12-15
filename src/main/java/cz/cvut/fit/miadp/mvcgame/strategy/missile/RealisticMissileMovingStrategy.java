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
        double alphaInRad = (-initAngle) * Math.PI / 180;


        int dX = (int) (initVelocity * time * Math.cos(alphaInRad));
        int dY = (int) (initVelocity * time * Math.sin(alphaInRad) + (1 / 2f * MvcGameConfig.GRAVITY * time * time) / 100F);
        //double alphaInRad = (- alpha) * Math.PI / 180;
        //int y = (int) (y0 + ((startingVel * time * Math.sin(alphaInRad)) + (1 / 2f * 8.91 * Math.pow(time, 2)) / 100F));

        missile.move(new Vector(dX, dY));

//        int x0 = missile.getPosition().getX();
//        int y0 = missile.getPosition().getY();
//        int alpha = missile.getAngle();
//        //float startingVel = missile.getVelocity();
//        float startingVel = missile.getVelocity();
//        float time = missile.getAge() / 100;
//        // // tady musí být plus oproti vzorci, protože naše kledání znamná zvětošovat Y
//        double alphaInRad = (- alpha) * Math.PI / 180;
//
//        int x = (int) (x0 + (startingVel * time * Math.cos(alphaInRad)));
//        int y = (int) (y0 + ((startingVel * time * Math.sin(alphaInRad)) + (1 / 2f * 8.91 * Math.pow(time, 2)) / 100F));
//
//        Position newPos = new Position(x, y);
//        missile.setPosition(newPos);
    }

}

package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;

public class SingleShootingMode implements IShootingMode {
    @Override
    public String getName() {
        return "SingleShootingMode";
    }

    @Override
    public void shoot(AbsCannon cannon) {
        cannon.primitiveShoot(new Vector(0, 0));
    }
}

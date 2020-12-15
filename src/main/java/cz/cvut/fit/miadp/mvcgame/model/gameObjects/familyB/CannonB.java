package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyB;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;

import java.util.List;

public class CannonB extends AbsCannon {
    public CannonB(Position position) {
        super(new DoubleShootingMode());
        this.position = position;
    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void primitiveShoot() {

    }

    @Override
    public List<AbsMissile> shoot() {
        return null;
    }

    @Override
    public void powerUp() {

    }

    @Override
    public void powerDown() {

    }

    @Override
    public void aimUp() {

    }

    @Override
    public void aimDown() {

    }

    @Override
    public AbsCannon clone() {
        return null;
    }
}

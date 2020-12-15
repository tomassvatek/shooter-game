package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;

public class CollisionA extends AbsCollision {
    public CollisionA(Position position) {
        super(position);
    }

    @Override
    public AbsCollision clone() {
        return new CollisionA(this.position.clone());
    }
}

package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyB;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;

public class CollisionB extends AbsCollision {
    public CollisionB(Position position) {
        super(position);
    }

    @Override
    public AbsCollision clone() {
        return new CollisionB(this.position.clone());

    }
}

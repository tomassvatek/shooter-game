package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyB;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class CollisionB extends AbsCollision {
    public CollisionB(Position position) {
        super(position);
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitCollision(this);
    }

    @Override
    public AbsCollision clone() {
        return new CollisionB(this.position.clone());
    }
}

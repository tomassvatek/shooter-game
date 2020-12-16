package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class CollisionA extends AbsCollision {
    public CollisionA(Position position) {
        super(position);
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitCollision(this);
    }

    @Override
    public AbsCollision clone() {
        return new CollisionA(this.position.clone());
    }
}

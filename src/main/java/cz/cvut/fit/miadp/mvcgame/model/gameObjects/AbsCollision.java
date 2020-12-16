package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.prototype.IPrototype;

public abstract class AbsCollision extends LifetimeLimitedGameObject implements IPrototype<AbsCollision> {

    public AbsCollision(Position position) {
        super(position);
    }

    @Override
    public abstract AbsCollision clone();
}

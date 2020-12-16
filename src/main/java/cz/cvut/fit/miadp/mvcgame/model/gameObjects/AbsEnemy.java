package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.prototype.IPrototype;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovable;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsEnemy extends LifetimeLimitedGameObject implements IPrototype<AbsEnemy>, IMovable {
    protected int bonus;

    public AbsEnemy(Position position, int bonus) {
        super(position);
        this.bonus = bonus;
    }

    @Override
    public abstract void move();

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitEnemy(this);
    }

    @Override
    public abstract AbsEnemy clone();

    public int getBonus() {
        return this.bonus;
    }

    public abstract int getMoveStep();
}

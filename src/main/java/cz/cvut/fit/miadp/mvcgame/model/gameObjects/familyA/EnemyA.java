package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.enemy.RandomEnemyMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class EnemyA extends AbsEnemy {
    private IMovingStrategy<AbsEnemy> movingStrategy;

    public EnemyA(Position position) {
        super(position);
        this.movingStrategy = new RandomEnemyMovingStrategy();
    }

    @Override
    public void move() {
        this.movingStrategy.updatePosition(this);
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitEnemy(this);
    }

    @Override
    public AbsEnemy clone() {
        return new EnemyA(this.position.clone());
    }
}

package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.enemy.RealisticEnemyMovingStrategy;

public class AdvanceEnemyA extends AbsEnemy {
    private IMovingStrategy<AbsEnemy> movingStrategy;

    public AdvanceEnemyA(Position position) {
        super(position, 2);
        this.movingStrategy = new RealisticEnemyMovingStrategy();
    }

    @Override
    public void move() {
        this.movingStrategy.updatePosition(this);
    }

    @Override
    public AbsEnemy clone() {
        return new AdvanceEnemyA(this.position);
    }
}

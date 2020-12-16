package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyB;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class EnemyB extends AbsEnemy {
    public EnemyB(Position position) {
        super(position, 5);
    }

    // FamilyB enemy is not moving
    @Override
    public void move() {
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitEnemy(this);
    }

    @Override
    public int getMoveStep() {
        return MvcGameConfig.ENEMY_STEP;
    }

    @Override
    public AbsEnemy clone() {
        return new EnemyB(this.position.clone());
    }
}

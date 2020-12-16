package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyB;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA.AdvanceEnemyA;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class AdvanceEnemyB extends AbsEnemy {
    public AdvanceEnemyB(Position position) {
        super(position, 10);
    }

    // FamilyB enemy is not moving
    @Override
    public void move() {

    }

    @Override
    public AbsEnemy clone() {
        return new AdvanceEnemyA(this.position);
    }

    @Override
    public int getMoveStep() {
        return MvcGameConfig.ADVANCED_ENEMY_STEP;
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitAdvanceEnemy(this);
    }

}

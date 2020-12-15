package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;

public interface IVisitor {
    void visitCannon(AbsCannon cannon);

    void visitMissile(AbsMissile missile);

    void visitEnemy(AbsEnemy enemy);

    void visitAdvanceEnemy(AbsEnemy enemy);

    void visitCollision(AbsCollision collision);

    void visitGameInfo(AbsGameInfo gameInfo);
}

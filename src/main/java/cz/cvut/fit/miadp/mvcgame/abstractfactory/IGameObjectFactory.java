package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;

public interface IGameObjectFactory {
    AbsCannon createCannon();

    AbsMissile createMissile(Position position, double initAngle, int initVelocity);

    AbsEnemy createEnemy();

    AbsEnemy createAdvanceEnemy();

    AbsCollision createCollision(Position position);

    AbsGameInfo createGameInfo(String text);
}
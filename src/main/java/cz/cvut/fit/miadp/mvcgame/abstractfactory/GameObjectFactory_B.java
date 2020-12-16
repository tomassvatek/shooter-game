package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyB.*;

import java.util.Random;

public class GameObjectFactory_B implements IGameObjectFactory {
    private IGameModel model;

    public GameObjectFactory_B(IGameModel model) {
        this.model = model;
    }

    @Override
    public AbsCannon createCannon() {
        return new CannonB(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y), this);
    }

    @Override
    public AbsMissile createMissile(Position position, double initAngle, int initVelocity) {
        return new MissileB(position, initAngle, initVelocity);
    }

    @Override
    public AbsEnemy createEnemy() {
        return new EnemyB(generateRandomPosition());
    }

    @Override
    public AbsEnemy createAdvanceEnemy() {
        return new AdvanceEnemyB(generateRandomPosition());
    }

    @Override
    public AbsCollision createCollision(Position position) {
        return new CollisionB(position);
    }

    @Override
    public AbsGameInfo createGameInfo(String text) {
        Position position = new Position(5, 10);
        return new GameInfoB(position, text);
    }

    @Override
    public AbsGameLevel createGameLevel() {
        return new GameLevelB(1, 0, this);
    }

    private Position generateRandomPosition() {
        Random rnd = new Random();

        int xBoundIndex = MvcGameConfig.MAX_X / 50;
        int yBoundIndex = MvcGameConfig.MAX_Y / 25;
        int posX = rnd.nextInt(xBoundIndex - 1) * 50 + 50;
        int posY = rnd.nextInt(yBoundIndex - 1) * 25 + 25;

        return new Position(posX, posY);
    }
}

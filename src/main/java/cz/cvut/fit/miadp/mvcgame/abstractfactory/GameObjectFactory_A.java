package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCollision;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsGameInfo;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA.*;

import java.util.Random;

public class GameObjectFactory_A implements IGameObjectFactory {
    private IGameModel model;

    public GameObjectFactory_A(IGameModel model) {
        this.model = model;
    }

    @Override
    public CannonA createCannon() {
        return new CannonA(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y), this);
    }

    @Override
    public MissileA createMissile(Position position, double initAngle, int initVelocity) {
        return new MissileA(position, initAngle, initVelocity,
                this.model.getMissileMovingStrategy());
    }

    @Override
    public AbsEnemy createEnemy() {
        Random rnd = new Random();

        int xBoundIndex = MvcGameConfig.MAX_X / 50;
        int yBoundIndex = MvcGameConfig.MAX_Y / 25;
        int posX = rnd.nextInt(xBoundIndex - 1) * 50 + 50;
        int posY = rnd.nextInt(yBoundIndex - 1) * 25 + 25;

        return new EnemyA(new Position(posX, posY));
    }

    @Override
    public AbsEnemy createAdvanceEnemy() {
        Random rnd = new Random();

        int xBoundIndex = MvcGameConfig.MAX_X / 50;
        int yBoundIndex = MvcGameConfig.MAX_Y / 25;
        int posX = rnd.nextInt(xBoundIndex - 1) * 50 + 50;
        int posY = rnd.nextInt(yBoundIndex - 1) * 25 + 25;

        return new AdvanceEnemyA(new Position(posX, posY));
    }

    @Override
    public AbsCollision createCollision(Position position) {
        return new CollisionA(position);
    }

    @Override
    public AbsGameInfo createGameInfo(String text) {
        Position position = new Position(5, 10);
        return new GameInfoA(position, text);
    }


    //TODO: Enemies, Collision, GameInfo
}

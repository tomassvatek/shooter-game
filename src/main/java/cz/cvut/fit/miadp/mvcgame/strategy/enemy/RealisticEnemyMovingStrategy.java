package cz.cvut.fit.miadp.mvcgame.strategy.enemy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.Random;

public class RealisticEnemyMovingStrategy implements IMovingStrategy<AbsEnemy> {
    private Position pos;

    public RealisticEnemyMovingStrategy() {
        this.pos = this.generatePoint();
    }

    @Override
    public void updatePosition(AbsEnemy enemy) {
        Position posE = enemy.getPosition();

        int xDif = pos.getX() - posE.getX();
        int yDif = pos.getY() - posE.getY();

        if (xDif < 0 && Math.abs(xDif) > 10) {
            enemy.move(new Vector(-enemy.getMoveStep(), 0));
        } else if (xDif > 0 && Math.abs(xDif) > 10) {
            enemy.move(new Vector(enemy.getMoveStep(), 0));
        } else if (yDif < 0 && Math.abs(yDif) > 10) {
            enemy.move(new Vector(0, -enemy.getMoveStep()));
        } else if (yDif > 0 && Math.abs(yDif) > 10) {
            enemy.move(new Vector(0, enemy.getMoveStep()));
        } else {
            this.pos = this.generatePoint();
        }
    }

    private Position generatePoint() {
        Random rnd = new Random();
        int x = -1;
        while (x < 30 || x > MvcGameConfig.MAX_X - 10) {
            x = rnd.nextInt(MvcGameConfig.MAX_X - 10);
        }
        int y = -1;
        while (y < 20 || y > MvcGameConfig.MAX_X - 10) {
            y = rnd.nextInt(MvcGameConfig.MAX_Y - 10);
        }

        return new Position(x, y);
    }
}

package cz.cvut.fit.miadp.mvcgame.strategy.enemy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.Random;

public class RandomEnemyMovingStrategy implements IMovingStrategy<AbsEnemy> {
    @Override
    public void updatePosition(AbsEnemy enemy) {
        int direction = getRandomDirection();

        updateDirection(enemy, direction);
        updateDirection(enemy, direction);
    }

    private void updateDirection(AbsEnemy enemy, int direction) {
        switch (direction) {
            case 0:
                moveRight(enemy);
                break;
            case 1:
                moveLeft(enemy);
                break;
            case 2:
                moveUp(enemy);
                break;
            case 3:
                moveDown(enemy);
                break;
        }
    }

    private int getRandomDirection() {
        Random random = new Random();
        return random.nextInt(4);
    }

    private void moveRight(AbsEnemy enemy) {
        if (enemy.getPosition().getX() + enemy.getMoveStep() < MvcGameConfig.MAX_X - 30)
            enemy.move(new Vector(enemy.getMoveStep(), 0));
    }

    private void moveLeft(AbsEnemy enemy) {
        if (enemy.getPosition().getX() - enemy.getMoveStep() > (MvcGameConfig.CANNON_POS_X + 50))
            enemy.move(new Vector(-enemy.getMoveStep(), 0));
    }

    private void moveUp(AbsEnemy enemy) {
        if (enemy.getPosition().getY() - enemy.getMoveStep() > 20)
            enemy.move(new Vector(0, -enemy.getMoveStep()));
    }

    private void moveDown(AbsEnemy enemy) {
        if (enemy.getPosition().getY() + enemy.getMoveStep() < MvcGameConfig.MAX_Y - 30)
            enemy.move(new Vector(0, enemy.getMoveStep()));
    }

}

package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyB;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsEnemy;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsGameLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLevelB extends AbsGameLevel {
    private IGameObjectFactory gameObjectFactory;
    private int nextLevelScoreStep;

    public GameLevelB(int level, int score, IGameObjectFactory gameObjectFactory) {
        this.level = level;
        this.score = score;
        this.gameObjectFactory = gameObjectFactory;

        this.nextLevelScoreStep = 1;
        this.levelsCount = 6;
    }

    @Override
    public List<AbsEnemy> generateEnemies(int enemiesAlive) {
        Random randomGen = new Random();

        int missingEnemies = MvcGameConfig.MAX_ENEMIES - enemiesAlive;
        List<AbsEnemy> enemies = new ArrayList<>();

        for (int i = 0; i < missingEnemies; i++) {
            int random = randomGen.nextInt(this.levelsCount - this.level);

            if (random == 0)
                enemies.add(this.gameObjectFactory.createAdvanceEnemy());
            else
                enemies.add(this.gameObjectFactory.createEnemy());
        }

        return enemies;
    }

    @Override
    public void addScore(int amount) {
        this.score += amount;
        if (this.score % this.nextLevelScoreStep == 0)
            this.levelUp();
    }

    private void levelUp() {
        this.level++;
        this.nextLevelScoreStep += 10;
    }

    @Override
    public AbsGameLevel clone() {
        return new GameLevelB(this.level, this.score, this.gameObjectFactory);
    }
}

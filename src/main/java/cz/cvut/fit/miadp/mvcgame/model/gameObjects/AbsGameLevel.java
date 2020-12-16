package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.prototype.IPrototype;

import java.util.List;

public abstract class AbsGameLevel implements IPrototype<AbsGameLevel> {
    protected int level;
    protected int score;
    protected int levelsCount;

    public int getLevel() {
        return this.level;
    }

    public int getScore() {
        return this.score;
    }

    public int getLevelsCount() { return this.levelsCount; }

    public abstract List<AbsEnemy> generateEnemies(int enemiesAlive);

    public abstract void addScore(int amount);

    @Override
    public abstract AbsGameLevel clone();
}

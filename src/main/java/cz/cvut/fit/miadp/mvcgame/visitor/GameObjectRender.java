package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;

public class GameObjectRender implements IVisitor {
    private IGameGraphics gr;

    public GameObjectRender() {
    }

    public void setGr(IGameGraphics gr) {
        this.gr = gr;
    }

    @Override
    public void visitCannon(AbsCannon cannon) {
        this.gr.drawImage("images/cannon.png", cannon.getPosition());
    }

    @Override
    public void visitMissile(AbsMissile missile) {
        this.gr.drawImage("images/missile.png", missile.getPosition());
    }

    @Override
    public void visitEnemy(AbsEnemy enemy) {
        this.gr.drawImage("images/enemy1.png", enemy.getPosition());
    }

    @Override
    public void visitAdvanceEnemy(AbsEnemy enemy) {
        this.gr.drawImage("images/enemy2.png", enemy.getPosition());
    }

    @Override
    public void visitCollision(AbsCollision collision) {
        this.gr.drawImage("images/collision.png", collision.getPosition());
    }

    @Override
    public void visitGameInfo(AbsGameInfo gameInfo) {
        this.gr.drawText(gameInfo.getText(), gameInfo.getPosition());
    }

}

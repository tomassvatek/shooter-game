package cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsGameInfo;

public class GameInfoA extends AbsGameInfo {
    public GameInfoA(Position position, String text) {
        this.position = position;
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public AbsGameInfo clone() {
        return new GameInfoA(this.position.clone(), this.text);
    }
}

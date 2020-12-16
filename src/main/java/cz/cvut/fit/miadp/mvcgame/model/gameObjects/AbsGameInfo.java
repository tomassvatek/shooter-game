package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.prototype.IPrototype;

public abstract class AbsGameInfo extends GameObject implements IPrototype<AbsGameInfo> {
    protected String text;

    public abstract String getText();

    public abstract void setText(String text);

    @Override
    public abstract AbsGameInfo clone();
}

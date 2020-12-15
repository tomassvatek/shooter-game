package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.prototype.IPrototype;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public abstract class AbsGameInfo extends GameObject implements IPrototype<AbsGameInfo> {
    protected String text;

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitGameInfo(this);
    }

    public abstract String getText();

    public abstract void setText(String text);

    @Override
    public abstract AbsGameInfo clone();
}

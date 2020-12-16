package cz.cvut.fit.miadp.mvcgame.decorator;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphicImplementor;
import cz.cvut.fit.miadp.mvcgame.model.Position;

public class GameGraphicDecorator implements IGameGraphicImplementor {
    protected IGameGraphicImplementor graphicImplementor;

    public GameGraphicDecorator(IGameGraphicImplementor graphicImplementor) {
        this.graphicImplementor = graphicImplementor;
    }

    @Override
    public void drawImage(String path, Position position) {
        this.graphicImplementor.drawImage(path, position);
    }

    @Override
    public void drawText(String text, Position position) {
        this.graphicImplementor.drawText(text, position);
    }

    @Override
    public void drawLine(Position beginPosition, Position endPosition) {
        this.graphicImplementor.drawLine(beginPosition, endPosition);
    }

    @Override
    public void clear() {
        this.graphicImplementor.clear();
    }
}

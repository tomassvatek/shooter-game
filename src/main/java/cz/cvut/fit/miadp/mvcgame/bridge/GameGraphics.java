package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.model.Position;

public class GameGraphics implements IGameGraphics {
    protected IGameGraphicImplementor implementor;

    public GameGraphics(IGameGraphicImplementor gameGraphicImplementor) {
        this.implementor = gameGraphicImplementor;
    }

    @Override
    public void drawImage(String path, Position position) {
        this.implementor.drawImage(path, position);
    }

    @Override
    public void drawText(String text, Position position) {
        this.implementor.drawText(text, position);
    }

    @Override
    public void drawRectangle(Position leftTop, Position rightBottom) {
        this.implementor.drawLine(leftTop, new Position(rightBottom.getX(), leftTop.getY()));

        this.implementor.drawLine(new Position(rightBottom.getX(), leftTop.getY()), rightBottom);

        this.implementor.drawLine(rightBottom, new Position(leftTop.getX(), rightBottom.getY()));

        this.implementor.drawLine(new Position(leftTop.getX(), rightBottom.getY()), leftTop);
    }

    @Override
    public void clear() {
        this.implementor.clear();
    }
}

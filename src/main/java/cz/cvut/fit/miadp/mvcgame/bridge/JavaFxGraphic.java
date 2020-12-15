package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class JavaFxGraphic implements IGameGraphicImplementor {
    protected GraphicsContext graphicsContext;

    public JavaFxGraphic(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void drawImage(String path, Position position) {
        Image img = new Image(path);
        this.graphicsContext.drawImage(img, position.getX(), position.getY());
    }

    @Override
    public void drawText(String text, Position position) {
        this.graphicsContext.fillText(text, position.getX(), position.getY());
    }

    @Override
    public void drawLine(Position beginPosition, Position endPosition) {
        this.graphicsContext.strokeLine(beginPosition.getX(), beginPosition.getY(), endPosition.getX(), endPosition.getY());
    }

    @Override
    public void clear() {
        graphicsContext.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);
    }
}

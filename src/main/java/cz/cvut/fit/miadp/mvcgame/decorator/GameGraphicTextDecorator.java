package cz.cvut.fit.miadp.mvcgame.decorator;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphicImplementor;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameGraphicTextDecorator extends GameGraphicDecorator {
    private GraphicsContext graphicsContext;

    public GameGraphicTextDecorator(IGameGraphicImplementor graphicImplementor, GraphicsContext graphicsContext) {
        super(graphicImplementor);
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void drawText(String text, Position position) {
        this.graphicsContext.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
        this.graphicImplementor.drawText(text, position);
    }
}

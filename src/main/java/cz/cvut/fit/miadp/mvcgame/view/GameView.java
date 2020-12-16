package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectRender;

public class GameView implements IObserver {
    private GameController controller;
    private IGameModel model;
    private IGameGraphics graphicContext;
    private GameObjectRender gameObjectRender;
    private boolean wasUpdate;

    private int updateCnt = 0;

    public GameView(IGameModel model) {
        this.model = model;
        this.controller = new GameController(model);
        this.graphicContext = null;
        this.wasUpdate = false;

        this.gameObjectRender = new GameObjectRender();
        this.model.register(this);
    }

    public GameController getController() {
        return controller;
    }

    public void render() {
        if (graphicContext == null)
            return;

        if (this.updateCnt > 0) {
            this.graphicContext.clear();

            for (GameObject gameObject : this.model.getGameObjects()) {
                gameObject.acceptVisitor(this.gameObjectRender);
            }

            this.updateCnt = 0;
        }
    }

    public void setGraphicContext(IGameGraphics gr) {
        this.graphicContext = gr;
        this.gameObjectRender.setGr(gr);
    }

    @Override
    public void update() {
        this.updateCnt++;
    }

    public boolean wasUpdate() {
        return this.wasUpdate;
    }
}

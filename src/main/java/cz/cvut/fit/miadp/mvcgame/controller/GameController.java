package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.command.*;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class GameController {
    private IGameModel model;
    private long lastShootTime = 0;

    public GameController(IGameModel model) {
        this.model = model;
    }

    public void processPressedKeys(String code) {
        switch (code) {
            case "UP":
                this.model.registerCommand(new MoveCannonUpCmd(this.model));
                break;
            case "DOWN":
                this.model.registerCommand(new MoveCannonDownCmd(this.model));
                break;
            case "SPACE":
                if (this.canShoot()) {
                    this.model.registerCommand(new CannonShootCmd(this.model));
                }
                break;
            case "W":
                this.model.registerCommand(new AimCannonUpCmd(this.model));
                break;
            case "S":
                this.model.registerCommand(new AimCannonDownCmd(this.model));
                break;
            case "D":
                this.model.registerCommand(new CannonPowerUpCmd(this.model));
                break;
            case "A":
                this.model.registerCommand(new CannonPowerDownCmd(this.model));
                break;
            case "O":
                this.model.registerCommand(new ToggleShootingModeCmd(this.model));
                break;
            case "P":
                this.model.registerCommand(new ToggleMovingStrategyCmd(this.model));
                break;
            case "B":
                //this.model.registerCommand(new UndoLastCmd(this.model));
                // TODO: Use command instead
                this.model.undoLastCommand();
                break;
            default:
                //nothing
        }
    }

    private boolean canShoot() {
        long now = System.currentTimeMillis();
        if (now - lastShootTime > 1000) {
            this.lastShootTime = now;
            return true;
        }

        return false;
    }
}

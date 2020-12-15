package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class ToggleShootingModeCmd extends AbstractGameCmd {
    public ToggleShootingModeCmd(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    protected void execute() {
        this.subject.toggleShootingMode();
    }
}

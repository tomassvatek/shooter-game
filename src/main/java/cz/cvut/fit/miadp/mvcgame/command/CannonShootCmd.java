package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public class CannonShootCmd extends AbstractGameCmd {

    public CannonShootCmd(IGameModel subject) {
        this.subject = subject;
    }

    @Override
    protected void execute() {
        this.subject.cannonShoot();
    }
}

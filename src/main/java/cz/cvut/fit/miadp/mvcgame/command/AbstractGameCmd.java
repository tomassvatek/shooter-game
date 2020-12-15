package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.IGameModel;

public abstract class AbstractGameCmd {
    protected IGameModel subject;
    protected Object memento;

    public void unExecute() {
        this.subject.setMemento(this.memento);
    }

    public void doExecute() {
        this.memento = this.subject.createMemento();
        this.execute();
    }

    protected abstract void execute();
}

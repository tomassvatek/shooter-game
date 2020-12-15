package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.command.MoveCannonDownCmd;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import org.junit.Assert;
import org.junit.Test;

public class UndoCommandTestCase {
    @Test
    public void undoCommandTest() {
        IGameModel model = new GameModel();

        int dxBefore = model.getCannonPosition().getX();
        int dyBefore = model.getCannonPosition().getY();

        model.registerCommand(new MoveCannonDownCmd(model));
        model.update();
        model.undoLastCommand();

        int dxAfter = model.getCannonPosition().getX();
        int dyAfter = model.getCannonPosition().getY();

        Assert.assertEquals(dxBefore, dxAfter);
        Assert.assertEquals(dyBefore, dyAfter);
    }
}
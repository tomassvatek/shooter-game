package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.command.ToggleShootingModeCmd;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.IGameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA.CannonA;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShootingModeTestCase {
    @Test
    public void doubleShootingModeTestCase() {
        IGameObjectFactory mockFactory = mock(IGameObjectFactory.class);
        when(mockFactory.createCannon()).thenReturn(new CannonA(new Position(0, 0), mockFactory));

        AbsCannon cannon = mockFactory.createCannon();
        String shootingModeName = cannon.getShootingMode();

        // toggle until DoubleShootingMode is not set
        while (shootingModeName != "DoubleShootingMode") {
            cannon.toggleShootingMode();
            shootingModeName = cannon.getShootingMode();
        }

        List<AbsMissile> missiles = cannon.shoot();

        Assert.assertEquals(2, missiles.size());
    }

    @Test
    public void singleShootingModeTestCase() {
        IGameObjectFactory mockFactory = mock(IGameObjectFactory.class);
        when(mockFactory.createCannon()).thenReturn(new CannonA(new Position(0, 0), mockFactory));

        AbsCannon cannon = mockFactory.createCannon();
        String shootingModeName = cannon.getShootingMode();

        // toggle until SignleShootingMode is not set
        while (shootingModeName != "SingleShootingMode") {
            cannon.toggleShootingMode();
            shootingModeName = cannon.getShootingMode();
        }

        List<AbsMissile> missiles = cannon.shoot();

        Assert.assertEquals(1, missiles.size());
    }

    @Test
    public void toggleShootingModeTest() {
        IGameModel model = new GameModel();

        String shootingModeBeforeToggle = model.getShootingModeName();
        model.registerCommand(new ToggleShootingModeCmd(model));
        model.update();

        String shootingModeAfterToggle = model.getShootingModeName();

        Assert.assertNotSame(shootingModeBeforeToggle, shootingModeAfterToggle);
    }
}

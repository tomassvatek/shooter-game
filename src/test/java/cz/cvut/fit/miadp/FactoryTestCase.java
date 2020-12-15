package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsCannon;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.AbsMissile;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.familyA.CannonA;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FactoryTestCase {
    @Test
    public void factoryTest() {
        IGameObjectFactory mockFactory = mock(IGameObjectFactory.class);
        when(mockFactory.createCannon()).thenReturn(new CannonA(new Position(0, 0), mockFactory));

        AbsCannon cannon = mockFactory.createCannon();
        List<AbsMissile> missiles = cannon.shoot();
        Assert.assertEquals(missiles.size(), 1);
    }
}

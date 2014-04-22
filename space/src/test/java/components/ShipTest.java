package components;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {

    Ship ship;

    @Before
    public void setUp(){
        this.ship = new Ship();
    }

    @Test
    public void defaultShipHasOneLifePoint(){
        int lifePoint = ship.getLifePoints();
        Assert.assertEquals(lifePoint, 1);
    }

    @Test
    public void defaultShipHasOneShotPower(){
        int lifePoint = ship.getLifePoints();
        Assert.assertEquals(lifePoint, 1);
    }
}

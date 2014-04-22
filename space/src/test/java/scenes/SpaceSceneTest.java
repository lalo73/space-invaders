package scenes;


import components.Ship;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SpaceSceneTest {
    @Test
    public void spaceSceneHasInvaderList(){
        SpaceScene scene = new SpaceScene();
        Assert.assertEquals(scene.getInvaderList(), new ArrayList<Ship>());
    }
    @Test
    public void spaceSceneHasShipList(){
        SpaceScene scene = new SpaceScene();
        Assert.assertEquals(scene.getShipList(), new ArrayList<Ship>());
    }

}

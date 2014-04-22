package scenes;


import components.Ship;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scenes.levels.Level1;
import space.SpaceGame;

import java.util.ArrayList;

public class SpaceSceneTest {

    private SpaceScene scene;

    @Before
    public void setUp() {
        this.scene = new Level1();
    }

    @Test
    public void spaceSceneHasInvaderList() {
        Assert.assertEquals(scene.getInvaderList(), new ArrayList<Ship>());
    }

    @Test
    public void spaceSceneHasShipList() {
        Assert.assertEquals(scene.getShipList(), new ArrayList<Ship>());
    }

    @Test
    public void hasNoBackgroundOnInit() {
        Assert.assertNull(this.scene.getBackground());
    }

    @Test
    public void hasBackgroundAfterSetAsCurrent() {
        SpaceGame game = new SpaceGame();
        game.setCurrentScene(this.scene);

        Assert.assertNotNull(this.scene.getBackground());
    }

}

package space;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class SpaceGameTest {
    Dimension dimension;
    SpaceGame game;

    @Before
    public void setUp(){
        this.game = new SpaceGame();
        this.dimension = game.getDisplaySize();
    }

    @Test
    public void getWidthFromConfigFile(){
        String configWidth = game.getConfig("screenWidth");
        double width = dimension.getWidth();
        Assert.assertEquals((int) width, (int) Double.parseDouble(configWidth));
    }

    @Test
    public void getHeightFromConfigFile(){
        String configHeight = game.getConfig("screenHeight");
        double width = dimension.getHeight();
        Assert.assertEquals((int) width, (int) Double.parseDouble(configHeight));
    }
}

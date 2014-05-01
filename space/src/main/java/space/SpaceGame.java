package space;


import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import config.Config;
import resources.Resource;
import scenes.levels.Level1;
import scenes.statics.PressStartScene;

import java.awt.*;
import java.util.HashMap;


public class SpaceGame extends Game {
    Config applicationConfig;
    HashMap<String, Resource> resources;


    @Override
    protected void initializeResources() {
        this.applicationConfig = new Config("application.xml");
        this.resources = new HashMap<String, Resource>();
        loadBackgrounds();
        loadInvaderImages();
        loadPlayerImages();
        loadShots();
        loadFX();
    }

    @Override
    protected void setUpScenes() {
        this.setCurrentScene(new PressStartScene());
    }

    public static void main(String[] args) throws Exception {
        new DesktopGameLauncher(new SpaceGame()).launch();
    }

    @Override
    public Dimension getDisplaySize() {
        int width = Integer.parseInt(getConfig("screenWidth"));
        int height = Integer.parseInt(getConfig("screenHeight"));
        return new Dimension(width, height);
    }

    @Override
    public String getTitle() {
        return getConfig("gameTitle");
    }

    public Config getConfigurations() {
        return this.applicationConfig;
    }

    public String getConfig(String key) {
        return this.getConfigurations().fetch(key);
    }

    public Resource getResource(String resourceName) {
        return this.resources.get(resourceName);
    }

    public void addResource(String key, String image) {
        resources.put(key, Resource.fromImage(image));
    }

    public void loadBackgrounds() {
        addResource("background", getConfig("backgroundFile"));
        addResource("gameOverBackground", getConfig("gameOverBackground"));
        addResource("pressStart", getConfig("pressStartBackground"));
    }

    public void loadInvaderImages() {
        addResource("invader-yellow", "invaders/invader1-small.png");
        addResource("invader-orange", "invaders/invader2-small.png");
        addResource("invader-violet", "invaders/invader3-small.png");
        addResource("invader-blue", "invaders/invader4-small.png");
        addResource("invader-green", "invaders/invader5-small.png");

        addResource("yellow", "invaders/lifes-less/invader1-small.png");
        addResource("yellow-1", "invaders/lifes-less/invader1-small-1.png");
        addResource("yellow-2", "invaders/lifes-less/invader1-small-2.png");

	    addResource("orange", "invaders/lifes-less/invader2-small.png");
	    addResource("orange-1", "invaders/lifes-less/invader2-small-1.png");
	    addResource("orange-2", "invaders/lifes-less/invader2-small-2.png");

	    addResource("violet", "invaders/lifes-less/invader3-small.png");
	    addResource("violet-1", "invaders/lifes-less/invader3-small-1.png");
	    addResource("violet-2", "invaders/lifes-less/invader3-small-2.png");

	    addResource("blue", "invaders/lifes-less/invader4-small.png");
	    addResource("blue-1", "invaders/lifes-less/invader4-small-1.png");
	    addResource("blue-2", "invaders/lifes-less/invader4-small-2.png");

	    addResource("green", "invaders/lifes-less/invader5-small.png");
	    addResource("green-1", "invaders/lifes-less/invader5-small-1.png");
	    addResource("green-2", "invaders/lifes-less/invader5-small-2.png");
    }

    public void loadPlayerImages() {
        addResource("player-ship1", getConfig("playerShip1"));
        addResource("player-ship2", getConfig("playerShip2"));
    }

    public void loadShots() {
        addResource("playerShot", getConfig("playersShotImage"));
        addResource("invaderShot", getConfig("invadersShotImage"));
    }

    public void loadFX() {
        addResource("nyanCat", getConfig("nyanCat"));
    }
}

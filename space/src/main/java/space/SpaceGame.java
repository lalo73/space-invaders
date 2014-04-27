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
        addResource("invader-yellow", "politician/pol1-min.png");
        addResource("invader-orange", "politician/pol2-min.png");
        addResource("invader-violet", "politician/pol3-min.png");
        addResource("invader-blue", "politician/pol4-min.png");
        addResource("invader-green", "politician/pol6-min.png");
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

package space;


import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import config.Config;
import resources.Resource;
import scenes.SpaceScene;

import java.awt.*;
import java.util.HashMap;


public class SpaceGame extends Game {
    Config applicationConfig;
    HashMap<String, Resource> resources;


    @Override
    protected void initializeResources() {
        this.applicationConfig = new Config("application.cnf");
        this.resources = new HashMap<String, Resource>();
        resources.put("background", Resource.fromImage(getConfig("backgroundFile")));

    }

    @Override
    protected void setUpScenes() {
        this.setCurrentScene(new SpaceScene());
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
}

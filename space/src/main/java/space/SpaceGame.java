package space;


import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import config.Config;
import resources.Resource;
import scenes.levels.Level1;

import java.awt.*;
import java.util.HashMap;


public class SpaceGame extends Game {
    Config applicationConfig;
    HashMap<String, Resource> resources;


    @Override
    protected void initializeResources() {
        this.applicationConfig = new Config("application.xml");
        this.resources = new HashMap<String, Resource>();
        loadBackground();
        loadInvaderImages();
    }

    @Override
    protected void setUpScenes() {
        this.setCurrentScene(new Level1());
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

    public void addResource(String key, String image){
        resources.put(key, Resource.fromImage(image));
    }

    public void loadBackground(){
        addResource("background", getConfig("backgroundFile"));
    }

    public void loadInvaderImages(){
        addResource("invader1","invaders/invader1-small.png");
        addResource("invader2","invaders/invader2-small.png");
        addResource("invader3","invaders/invader3-small.png");
        addResource("invader4","invaders/invader4-small.png");
        addResource("invader5","invaders/invader5-small.png");
    }
}

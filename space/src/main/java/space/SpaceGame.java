package space;


import com.uqbar.vainilla.Game;
import config.Config;

import java.awt.*;

public class SpaceGame extends Game{
    Config applicationConfig;


    @Override
    protected void initializeResources() {
        this.applicationConfig = new Config("application.cnf");
    }

    @Override
    protected void setUpScenes() {
        
    }

    @Override
    public Dimension getDisplaySize() {
        int width = Integer.parseInt(getConfig("screenWidth"));
        int height = Integer.parseInt(getConfig("screenHeight"));
        return new Dimension(width, height);
    }

    @Override
    public String getTitle() {
        return null;
    }

    public Config getConfigurations(){
        return this.applicationConfig;
    }

    public String  getConfig(String key){
        return this.getConfigurations().fetch(key);
    }
}

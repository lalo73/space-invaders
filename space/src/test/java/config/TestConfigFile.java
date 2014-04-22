package config;

import org.junit.Assert;
import org.junit.Test;

public class TestConfigFile {

    @Test
    public void getConfigurations(){
        new Config("application.cnf");
    }

    @Test
    public void getSomeConfiguration(){
        Config c = new Config("application.cnf");
        String projectName = c.fetch("projectName");
        Assert.assertEquals(projectName,"SpaceInvaders" );
    }
}

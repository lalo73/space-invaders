import config.Config;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

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

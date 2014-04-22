import config.Config;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

public class TestConfigFile {

    @Test
    public void getConfigurations(){
        Config.getConfigurations();
    }

    @Test
    public void getSomeConfiguration(){
        Properties p = Config.getConfigurations();
        String projectName = (String) p.get("projectName");
        Assert.assertEquals(projectName,"SpaceInvaders" );
    }
}

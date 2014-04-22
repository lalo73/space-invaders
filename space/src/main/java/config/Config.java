package config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Config {

    public static Properties getConfigurations() {
        URL configFile = Config.class.getResource("application.cnf");
        try {
            InputStream configFileStream = configFile.openStream();
            Properties p = new Properties();
            p.load(configFileStream);
            configFileStream.close();
            return p;
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }
}
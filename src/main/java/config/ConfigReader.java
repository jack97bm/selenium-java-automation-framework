package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties = new Properties();

    public ConfigReader() {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties",e);
        }
    }

    public String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) throw new RuntimeException("Key not found: " + key);
        return value;
    }
}

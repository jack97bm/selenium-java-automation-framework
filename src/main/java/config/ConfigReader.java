package config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConfigReader {
    private Map<String, String> config = new HashMap<>();

    public ConfigReader(String browser, String baseUrl, int timeout, String username, String password) {
        config.put("browser", browser);
        config.put("baseUrl", baseUrl);
        config.put("timeout", String.valueOf(timeout));
        config.put("username", username);
        config.put("password", password);
    }

    public String get(String key) {
        if (!config.containsKey(key)) {
            throw new IllegalArgumentException("Key not found: " + key);
        }
        return config.get(key);
    }

    public void getAllKeys() {
        System.out.print("Keys : ");
        Set<String> keys = config.keySet();
        for(String key : keys) {
            System.out.print(key+" ");
        }
    }

}

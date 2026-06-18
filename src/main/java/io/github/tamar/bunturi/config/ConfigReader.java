package io.github.tamar.bunturi.config;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader(){

        properties = new Properties();
        try(InputStream input =
            getClass().getClassLoader().getResourceAsStream("config.properties")){
            if(input == null){
                throw new RuntimeException("config.properties not found on the classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }

    public String getBaseUrl(){
        return properties.getProperty("baseUrl");
    }

    public int getExplicitWait (){
        return Integer.parseInt(properties.getProperty("explicitWait"));

    }
}

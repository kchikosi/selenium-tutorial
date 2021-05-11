package environment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = PropertiesManager.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("app.properties");
        properties.load(inputStream);
        return  properties;
    }

    public static String getKey(String value) throws IOException {
        return PropertiesManager.getProperties().getProperty(value);
    }

    public static String getValue(String key) throws IOException {
        return (String) PropertiesManager.getProperties().get(key);
    }
}
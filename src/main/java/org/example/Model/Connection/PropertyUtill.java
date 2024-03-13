package org.example.Model.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyUtill {

    private static Properties properties = new Properties();

    static
    {
        loadToProp();
    }

    private static void loadToProp() {
        try (InputStream inputStream = PropertyUtill.class.getClassLoader().getResourceAsStream("application.properties");) {
            properties.load(inputStream);
        }
        catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }

    }

    public static String GetProperties(String key)
    {
        return properties.getProperty(key);
    }


}

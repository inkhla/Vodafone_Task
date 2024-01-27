package org.example.Utils.Config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties getCred() throws IOException {
        FileReader reader = new FileReader("src/main/java/org/example/Utils/Config/properties/credentials.properties");

        Properties properties = new Properties();
        properties.load(reader);

        return properties;
    }
}

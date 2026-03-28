package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            String path = "src/test/resources/configuration.properties";

            FileInputStream input = new FileInputStream(path);

            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (IOException e) {
            System.out.println("Properties faylı oxunarkən xəta baş verdi!");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }
}
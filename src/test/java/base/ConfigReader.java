package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties initProperties(String env) {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/" + env.toLowerCase() + ".properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}

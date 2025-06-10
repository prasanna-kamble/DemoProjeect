package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DriverFactory {
    public static WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omkar\\Downloads\\chromedriver-win64\\chromedriver.exe"); // Update path

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // Wait up to 10 seconds
        return driver;
    }
}

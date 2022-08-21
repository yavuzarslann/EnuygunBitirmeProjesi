package utilities;

import framework.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;


public class DriverSetup {
    static Map<String, Object> data ;
    public static WebDriver driver;

    public static void initializeDriver(){
        data = ConfigManager.initialize_Properties();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        String url = String.valueOf(data.get("url"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }
}

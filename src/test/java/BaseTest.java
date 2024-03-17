import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String downloadFilepath;

    @BeforeEach
    public void setUp() {
        String browserType = System.getProperty("browser", "chrome"); // Default to Chrome if no system property is set
        downloadFilepath = "C:/Users/sebas/Downloads";
        if (browserType.equals("brave")) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/sebas/Downloads/driver/chromedriver-win64/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            options.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        } else {
            // Assuming "chrome" is the default browser type
            System.setProperty("webdriver.chrome.driver", "C:/Users/sebas/Downloads/driver/chromedriver-win64/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

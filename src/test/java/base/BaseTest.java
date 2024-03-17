package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.HashMap;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String downloadFilepath;

    @BeforeEach
    public void setUp() {
        String browserType = System.getProperty("browser", "chrome");
        downloadFilepath = Paths.get(System.getProperty("user.home"), "Downloads").toString();

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", true); // Puedes ajustar esto según tus necesidades
        chromePrefs.put("download.default_directory", downloadFilepath);
        options.setExperimentalOption("prefs", chromePrefs);

        options.addArguments("--start-maximized");

        if ("headless".equals(System.getProperty("mode"))) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
        }

        if ("brave".equals(browserType.toLowerCase())) {
            options.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
        }

        System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.home"), "Downloads", "driver", "chromedriver-win64", "chromedriver.exe").toString());
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

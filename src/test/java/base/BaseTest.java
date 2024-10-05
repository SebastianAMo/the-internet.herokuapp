package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String downloadFilepath;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        String browserType = System.getProperty("browser", "chrome");
        downloadFilepath = Paths.get(System.getProperty("user.home"), "Downloads").toString();

        // Seleccionar el navegador en base a la propiedad "browser"
        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.prompt_for_download", false);
            chromePrefs.put("download.directory_upgrade", true);
            chromePrefs.put("safebrowsing.enabled", true);
            chromePrefs.put("download.default_directory", downloadFilepath);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--start-maximized");

            if ("headless".equals(System.getProperty("mode"))) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
            }

            // Leer la URL del hub de Selenium Grid desde la propiedad del sistema
            String gridUrl = System.getProperty("SELENIUM_GRID_URL", "http://localhost:4444/wd/hub");
            driver = new RemoteWebDriver(new URL(gridUrl), options);

        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();

            if ("headless".equals(System.getProperty("mode"))) {
                options.addArguments("--headless");
            }

            // Leer la URL del hub de Selenium Grid desde la propiedad del sistema
            String gridUrl = System.getProperty("SELENIUM_GRID_URL", "http://localhost:4444/wd/hub");
            driver = new RemoteWebDriver(new URL(gridUrl), options);
        }

        // Cargar la página de prueba
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

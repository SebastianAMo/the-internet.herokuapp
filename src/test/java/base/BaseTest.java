package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import org.testng.annotations.Optional;
public abstract class BaseTest {
    protected WebDriver driver;
    protected String downloadFilepath;

    @BeforeMethod
    @Parameters({"browser", "SELENIUM_GRID_URL","mode"})
    public void setUp(String browserType, String gridUrl,@Optional("defaultMode")  String mode) throws MalformedURLException {
        browserType = browserType != null ? browserType : System.getProperty("browser", "chrome");
        gridUrl = gridUrl != null ? gridUrl : System.getProperty("SELENIUM_GRID_URL", "http://localhost:4444/wd/hub");
        mode = mode != null ? mode : System.getProperty("mode");
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

            if ("headless".equalsIgnoreCase(mode)) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
            }

            driver = new RemoteWebDriver(new URL(gridUrl), options);

        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();

            if ("headless".equalsIgnoreCase(mode)) {
                options.addArguments("--headless");
            }

            driver = new RemoteWebDriver(new URL(gridUrl), options);
        }

        // Cargar la página de prueba
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;

public abstract class BaseTest {

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    protected String downloadFilepath;

    protected WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    @BeforeMethod
    @Parameters({"browser", "SELENIUM_GRID_URL", "mode"})
    public void setUp(String browserType,
                      String gridUrl,
                      @Optional("normal") String mode) throws MalformedURLException {

        downloadFilepath = Paths.get(System.getProperty("user.home"), "Downloads").toString();

        System.out.println("Download path: " + downloadFilepath);
        System.out.println("Browser: " + browserType);
        System.out.println("Grid: " + gridUrl);
        System.out.println("Mode: " + mode);

        WebDriver driver;

        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = setupChromeDriver(gridUrl, mode);
                break;
            case "firefox":
                driver = setupFirefoxDriver(gridUrl, mode);
                break;
            default:
                throw new IllegalArgumentException("Navegador no soportado: " + browserType);
        }

        threadLocalDriver.set(driver);

        getDriver().get("https://the-internet.herokuapp.com/");
    }

    private WebDriver setupChromeDriver(String gridUrl, String mode) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("download.default_directory", downloadFilepath);
        options.setExperimentalOption("prefs", chromePrefs);

        if ("headless".equalsIgnoreCase(mode)) {
            options.addArguments("--headless", "--disable-gpu");
        }

        options.addArguments("--start-maximized");
        return new RemoteWebDriver(new URL(gridUrl), options);
    }

    private WebDriver setupFirefoxDriver(String gridUrl, String mode) throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();

        if ("headless".equalsIgnoreCase(mode)) {
            options.addArguments("--headless");
        }

        return new RemoteWebDriver(new URL(gridUrl), options);
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            threadLocalDriver.remove();
        }
    }
}

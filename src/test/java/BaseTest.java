import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Configure the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/Users/sebas/Downloads/driver/chromedriver-win64//chromedriver.exe");

        // Add the WebDriver options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        // Close the browser and end the session
        if (driver != null) {
            driver.quit();
        }
    }
}

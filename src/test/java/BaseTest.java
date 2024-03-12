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
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        // Add the WebDriver options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser and end the session
        if (driver != null) {
            driver.quit();
        }
    }
}

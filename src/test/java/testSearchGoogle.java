import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class testSearchGoogle extends BaseTest {

    @Test
    public void abrirGoogle() throws InterruptedException {
        // Navega a Google
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the search bar to appear
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        // Write "selenium" in the search bar
        searchBar.sendKeys("selenium");
        searchBar.submit();

        Thread.sleep(2000);
    }
}

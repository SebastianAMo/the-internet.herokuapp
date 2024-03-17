package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class fileDownloadPage {

        private WebDriver driver;

        public By goPage = By.xpath("//*[@id=\"content\"]/ul/li[17]/a");
        public By downloadLink = By.xpath("//*[@id=\"content\"]/div/a[1]");

        public fileDownloadPage(WebDriver driver) {
            this.driver = driver;
        }

        public void clickOnGoPage() {
            driver.findElement(goPage).click();
        }

        public String clickOnDownloadLink() {
            WebElement link = driver.findElement(downloadLink);
            link.click();
            return link.getText();
        }

        public void checkFileDownloaded(String fileName) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(fileName)));
        }

}

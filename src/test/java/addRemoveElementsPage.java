
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class addRemoveElementsPage {

    private WebDriver driver;

    public By goPage = By.xpath("//*[@id=\"content\"]/ul/li[2]/a");
    public By addElement = By.xpath("//*[@id=\"content\"]/div/button");
    public By removeElement = By.xpath("//*[@id=\"elements\"]/button");

    public addRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnGoPage() {
        driver.findElement(goPage).click();
    }

    public void clickOnAddElement() {
        driver.findElement(addElement).click();
    }

    public void clickOnRemoveElement() {
        driver.findElement(removeElement).click();
    }

    public int getNumberOfElements() {
        return driver.findElements(removeElement).size();
    }

    public void waitForElementToAppear(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkboxesPage {

    private WebDriver driver;

    public By goPage = By.xpath("//*[@id=\"content\"]/ul/li[6]/a");

    public By checkbox1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
    public By checkbox2 = By.xpath("//*[@id=\"checkboxes\"]/input[2]");

    public checkboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnGoPage() {
        driver.findElement(goPage).click();
    }

    public void clickOnCheckbox1() {
        driver.findElement(checkbox1).click();
    }

    public void clickOnCheckbox2() {
        driver.findElement(checkbox2).click();
    }

    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return driver.findElement(checkbox2).isSelected();
    }
}

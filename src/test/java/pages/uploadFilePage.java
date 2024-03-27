package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class uploadFilePage {
    private WebDriver driver;

    public By goPage = By.xpath("//*[@id=\"content\"]/ul/li[18]/a");
    public By uploadFile = By.xpath("//*[@id=\"file-upload\"]");
    public By uploadButton = By.xpath("//*[@id=\"file-submit\"]");
    public By checkFileUpload = By.xpath("//*[@id=\"content\"]/div/h3");

    public uploadFilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnGoPage() {
        driver.findElement(goPage).click();
    }

    public void uploadFile (String filePath){
        WebElement uploadField = driver.findElement(uploadFile);
        uploadField.sendKeys(filePath);
    }

    public void uploadButton(){
        WebElement uploadButton1 = driver.findElement(uploadButton);
        uploadButton1.click();
    }

    public String checkFileUpload(){
        WebElement message = driver.findElement(checkFileUpload);
        return message.getText();
    }
}

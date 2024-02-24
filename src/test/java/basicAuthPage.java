import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.chromium.HasCdp;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.Duration;

public class basicAuthPage {

    private WebDriver driver;

    public By goPage = By.xpath("//*[@id=\"content\"]/ul/li[3]/a");
    public By successMessage = By.xpath("//*[@id=\"content\"]/div/p");

    public basicAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnGoPage() {
        driver.findElement(goPage).click();
    }

    public void addHeaders(String username, String password) {
        ((HasCdp) driver).executeCdpCommand("Network.enable", new HashMap<>());
        String encodedAuth = Base64.getEncoder().encodeToString((username+":"+password).getBytes());
        Map<String, Object> headers =
                ImmutableMap.of("headers", ImmutableMap.of("authorization", "Basic " + encodedAuth));

        ((HasCdp) driver).executeCdpCommand("Network.setExtraHTTPHeaders", headers);
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}

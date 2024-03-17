package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class brokenImagePage {

    private final HttpClient httpClient;
    private WebDriver driver;

    public By goPage = By.xpath("//*[@id=\"content\"]/ul/li[4]/a");
    public By Webimages = By.tagName("img");

    public brokenImagePage(WebDriver driver) {
        this.driver = driver;
        this.httpClient = HttpClient.newHttpClient();
    }

    public void clickOnGoPage() {
        driver.findElement(goPage).click();
    }

    public int getNumberOfBrokenImages() {
        int brokenImages = 0;
        List<WebElement> images = driver.findElements(Webimages);
        for (WebElement image : images) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                brokenImages++;
            }
        }
        return brokenImages;
    }

    public int getNumberofBrokenImagesWithHTTP() throws IOException, InterruptedException {
        int brokenImagesCount = 0;
        List<WebElement> images = driver.findElements(Webimages);
        for (WebElement image : images) {
            String src = image.getAttribute("src");
            if (src != null && !src.isEmpty()) {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(src))
                        .GET()
                        .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() != 200) {
                    brokenImagesCount++;
                }
            }
        }
        return brokenImagesCount;
    }
}

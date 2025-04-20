package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import org.testng.annotations.DataProvider;
public class testSearchGoogle extends BaseTest {

    @DataProvider(name = "searchTerms", parallel = true)
    public Object[][] getSearchTerms() {
        return new Object[][]{
                {"selenium"},
                {"testng"},
                {"java"},
                {"webdriver"},
                {"automation"},
                {"chrome"},
                {"firefox"},
                {"testing"}
        };
    }

    @Test(dataProvider = "searchTerms")
    public void abrirGoogle(String searchTerm) throws InterruptedException {
        // Navega a Google
        WebDriver driver = getDriver();
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        // Escribe el término recibido por el data provider
        searchBar.sendKeys(searchTerm);
        searchBar.submit();

        System.out.println("Buscando: " + searchTerm + " | Thread ID: " + Thread.currentThread().getId());
        Thread.sleep(2000);
    }
}

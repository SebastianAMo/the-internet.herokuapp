package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.brokenImagePage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class brokenImageTest extends BaseTest {
    private pages.brokenImagePage brokenImagePage;

    @Test
    public void testBrokenImages() throws InterruptedException {
        brokenImagePage = new brokenImagePage(driver);
        brokenImagePage.clickOnGoPage();
        assertEquals(2, brokenImagePage.getNumberOfBrokenImages());
        Thread.sleep(2000);
    }

    @Test
    public void testBrokenImagesWithHTTP() throws InterruptedException, IOException {
        brokenImagePage = new brokenImagePage(driver);
        brokenImagePage.clickOnGoPage();
        assertEquals(2, brokenImagePage.getNumberofBrokenImagesWithHTTP());
        Thread.sleep(2000);
    }
}

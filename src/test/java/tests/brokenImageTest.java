package tests;

import base.BaseTest;
import pages.brokenImagePage;

import java.io.IOException;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

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

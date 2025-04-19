package tests;

import base.BaseTest;
import pages.brokenImagePage;

import java.io.IOException;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class BrokenImageTest extends BaseTest {
    private pages.brokenImagePage brokenImagePage;

    @Test
    public void testBrokenImages() throws InterruptedException {
        brokenImagePage = new brokenImagePage(driver);
        brokenImagePage.clickOnGoPage();
        assertEquals( brokenImagePage.getNumberOfBrokenImages(), 2);
        Thread.sleep(2000);
    }

    @Test
    public void testBrokenImagesWithHTTP() throws InterruptedException, IOException {
        brokenImagePage = new brokenImagePage(driver);
        brokenImagePage.clickOnGoPage();
        assertEquals(brokenImagePage.getNumberofBrokenImagesWithHTTP(), 2);
        Thread.sleep(2000);
    }
}

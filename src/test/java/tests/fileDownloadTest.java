package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.fileDownloadPage;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class fileDownloadTest extends BaseTest {
    private pages.fileDownloadPage fileDownloadPage;

    @Test
    public void testFileDownload() throws InterruptedException {
        fileDownloadPage = new fileDownloadPage(driver);
        fileDownloadPage.clickOnGoPage();
        String fileName = fileDownloadPage.clickOnDownloadLink();
        fileDownloadPage.checkFileDownloaded(fileName);
        Thread.sleep(2000);
        try {
            File file = new File(System.getProperty("user.home") + "/Downloads/" + fileName);
            assertTrue(file.exists());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            File file = new File(System.getProperty("user.home") + "/Downloads/" + fileName);
            file.deleteOnExit();
        }
    }
}

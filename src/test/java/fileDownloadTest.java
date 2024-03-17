import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.time.Duration;
public class fileDownloadTest extends BaseTest {
    private fileDownloadPage fileDownloadPage;

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

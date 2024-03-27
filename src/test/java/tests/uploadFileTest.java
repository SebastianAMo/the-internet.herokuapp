package tests;
import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.uploadFilePage;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class uploadFileTest extends BaseTest{
    private pages.uploadFilePage uploadFilePage;
    private String filePath = System.getProperty("user.dir") + "/src/test/resources/test.json";

    @Test
    public void testFileUploadSucces() throws InterruptedException {
        uploadFilePage = new uploadFilePage(driver);
        uploadFilePage.clickOnGoPage();
        System.out.println(filePath);
        uploadFilePage.uploadFile(filePath);
        Thread.sleep(2000);
        uploadFilePage.uploadButton();
        String message = uploadFilePage.checkFileUpload();
        assertEquals(message , "File Uploaded!");
    }

    // The idea is that the form should indicate that a file needs to be uploaded. However,
    // what happens is that the page fails; that is, it does not handle the error of not uploading a file before moving on to the next step.
    @Test
    public void testFileUploadFileFail() throws InterruptedException {
        uploadFilePage = new uploadFilePage(driver);
        uploadFilePage.clickOnGoPage();
        uploadFilePage.uploadButton();
        String message = uploadFilePage.checkFileUpload();
        assertEquals(message , "File is not uploaded!");
    }
}

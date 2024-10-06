package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.basicAuthPage;
import static org.testng.Assert.assertEquals;


public class basicAuthTest extends BaseTest {
    private pages.basicAuthPage basicAuthPage;

    @Test
    public void successLogin()  throws InterruptedException{
        basicAuthPage = new basicAuthPage(driver);
        basicAuthPage.addHeaders("admin", "admin");
        basicAuthPage.clickOnGoPage();
        assertEquals("Congratulations! You must have the proper credentials.", basicAuthPage.getSuccessMessage());
        Thread.sleep(2000);
    }
}

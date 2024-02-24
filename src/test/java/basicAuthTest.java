import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class basicAuthTest extends BaseTest {
    private basicAuthPage basicAuthPage;

    @Test
    public void successLogin()  throws InterruptedException{
        basicAuthPage = new basicAuthPage(driver);
        basicAuthPage.addHeaders("admin", "admin");
        basicAuthPage.clickOnGoPage();
        assertEquals("Congratulations! You must have the proper credentials.", basicAuthPage.getSuccessMessage());
        Thread.sleep(2000);
    }
}

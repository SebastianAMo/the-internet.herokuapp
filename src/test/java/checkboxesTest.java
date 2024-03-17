import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class checkboxesTest extends BaseTest {
    private  checkboxesPage checkboxesPage;

    @Test
    public void testCheckbox1() throws InterruptedException {
        checkboxesPage = new checkboxesPage(driver);
        checkboxesPage.clickOnGoPage();
        checkboxesPage.clickOnCheckbox1();
        assertTrue(checkboxesPage.isCheckbox1Selected());
    }

    @Test
    public void testCheckbox2() throws InterruptedException {
        checkboxesPage = new checkboxesPage(driver);
        checkboxesPage.clickOnGoPage();
        checkboxesPage.clickOnCheckbox2();
        assertFalse(checkboxesPage.isCheckbox2Selected());
    }
}

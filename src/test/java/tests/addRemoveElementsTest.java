package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.addRemoveElementsPage;

import static org.testng.Assert.assertEquals;

public class addRemoveElementsTest extends BaseTest {
    private pages.addRemoveElementsPage addRemoveElementsPage;

    @BeforeMethod
    public void setUp() {
        addRemoveElementsPage = new addRemoveElementsPage(driver);
    }

    @Test
    public void checkNumberOfElements() throws InterruptedException {
        addRemoveElementsPage.clickOnGoPage();
        addRemoveElementsPage.clickOnAddElement();

        assertEquals(addRemoveElementsPage.getNumberOfElements(), 1);

        addRemoveElementsPage.clickOnRemoveElement();

        assertEquals(addRemoveElementsPage.getNumberOfElements(), 0);
    }

    @Test
    public void checkNumberOfElements2() throws InterruptedException {
        addRemoveElementsPage.clickOnGoPage();
        addRemoveElementsPage.clickOnAddElement();
        addRemoveElementsPage.clickOnAddElement();
        addRemoveElementsPage.clickOnAddElement();

        assertEquals(addRemoveElementsPage.getNumberOfElements(), 3);

        addRemoveElementsPage.clickOnRemoveElement();
        addRemoveElementsPage.clickOnRemoveElement();

        assertEquals(addRemoveElementsPage.getNumberOfElements(), 1);
    }
}

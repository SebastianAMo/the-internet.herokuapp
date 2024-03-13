import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class addRemoveElementsTest extends BaseTest {
    private addRemoveElementsPage addRemoveElementsPage;

    @Test
    public void checkNumberOfElements() throws InterruptedException {
        addRemoveElementsPage = new addRemoveElementsPage(driver);
        Thread.sleep(3000);
        addRemoveElementsPage.clickOnGoPage();
        addRemoveElementsPage.clickOnAddElement();
        //HOLA ESTOS SON MIS CAMBIOS



        addRemoveElementsPage.clickOnRemoveElement();

        assertEquals(0, addRemoveElementsPage.getNumberOfElements());

    }

    @Test
    public void checkNumberOfElements2() throws InterruptedException {
        addRemoveElementsPage = new addRemoveElementsPage(driver);
        addRemoveElementsPage.clickOnGoPage();
        addRemoveElementsPage.clickOnAddElement();
        addRemoveElementsPage.clickOnAddElement();
        addRemoveElementsPage.clickOnAddElement();

        assertEquals(3, addRemoveElementsPage.getNumberOfElements());

        addRemoveElementsPage.clickOnRemoveElement();
        addRemoveElementsPage.clickOnRemoveElement();

        assertEquals(1, addRemoveElementsPage.getNumberOfElements());

    }

}
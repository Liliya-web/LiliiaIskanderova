package ru.training.at.hw3.ex2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.testng.annotations.Test;
import ru.training.at.hw3.BaseTest;
import ru.training.at.hw3.IndexPage;
import ru.training.at.hw3.PageObject;

public class Exercise2Tests extends BaseTest {

    @Test
    public void exercise2Test() {
        //        1. Open test site
        new IndexPage(driver).open();

        //        2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //        3. Perform login
        new PageObject(driver).login(USERNAME, PASSWORD);

        //        4. Assert Username
        assertEquals(new PageObject(driver).checkUsername(), "ROMAN IOVLEV");

        //        5. Open through the header menu Service -> Different Elements Page
        new PageObject(driver).clickOnServicesDifferentElementsMenuHead();

        //        6. Select checkboxes Water, Wind
        new PageObject(driver).selectWaterCheckBox();
        new PageObject(driver).selectWindCheckbox();

        //        7. Select radio Selen
        new PageObject(driver).selectSelenRadio();

        //        8. Select in dropdown Yellow
        new PageObject(driver).selectYellowInDropdown();

        //        9. Assert that:
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //    • for radio button there is a log row and value is corresponded to the status of radio button
        //    • for dropdown there is a log row and value is corresponded to the selected value
        assertNotNull(new PageObject(driver).logTexts());
        List<String> logTexts = new PageObject(driver).logTexts();
        //        Yellow
        assertTrue(logTexts.get(0).contains("Colors: value changed to Yellow"));
        //        Selen - little bag. "Metal" does not start with the capital letter
        assertTrue(logTexts.get(1).contains("metal: value changed to Selen"));
        //        Wind
        assertTrue(logTexts.get(2).contains("Wind: condition changed to true"));
        //        Water
        assertTrue(logTexts.get(3).contains("Water: condition changed to true"));
    }
}

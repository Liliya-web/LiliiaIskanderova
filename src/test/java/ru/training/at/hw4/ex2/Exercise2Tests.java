package ru.training.at.hw4.ex2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw4.BaseTest;

public class Exercise2Tests extends BaseTest {

    @Test
    public void exercise2Test() {
        //        1. Open test site
        actionStep.openIndexPage();

        //        2. Assert Browser title
        assertionStep.assertTitle("Home Page");

        //        3. Perform login
        actionStep.login(USERNAME, PASSWORD);

        //        4. Assert Username
        assertionStep.assertUsername("ROMAN IOVLEV");

        //        5. Open through the header menu Service -> Different Elements Page
        actionStep.clickOnServicesDifferentElementsMenuHead();

        //        6. Select checkboxes Water, Wind
        actionStep.selectWaterCheckbox();
        actionStep.selectWindCheckbox();

        //        7. Select radio Selen
        actionStep.selectSelenRadio();

        //        8. Select in dropdown Yellow
        actionStep.selectYellowInDropdown();

        //        9. Assert that:
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //    • for radio button there is a log row and value is corresponded to the status of radio button
        //    • for dropdown there is a log row and value is corresponded to the selected value
        //        Yellow
        assertTrue(pageObject.log1Color().contains("Colors: value changed to Yellow"));
        //        Selen - little bag. "Metal" does not start with the capital letter
        assertTrue(pageObject.log2Metal().contains("metal: value changed to Selen"));
        //        Wind
        assertTrue(pageObject.log3Wind().contains("Wind: condition changed to true"));
        //        Water
        assertTrue(pageObject.log4Water().contains("Water: condition changed to true"));
    }
}

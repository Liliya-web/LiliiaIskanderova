package ru.training.at.hw6.ex2;

import org.testng.annotations.Test;
import ru.training.at.hw6.BaseTest;

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
        assertionStep.assertTextLog1YellowColor("Colors: value changed to Yellow");
        //        Selen - little bag. "Metal" does not start with the capital letter
        assertionStep.assertTextLog2MetalSelen("metal: value changed to Selen");
        //        Wind
        assertionStep.assertTextLog3Wind("Wind: condition changed to true");
        //        Water
        assertionStep.assertTextLog4Water("Water: condition changed to true");
    }
}

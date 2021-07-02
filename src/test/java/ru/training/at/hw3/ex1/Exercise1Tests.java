package ru.training.at.hw3.ex1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw3.BaseTest;
import ru.training.at.hw3.IndexPage;
import ru.training.at.hw3.PageObject;

public class Exercise1Tests extends BaseTest {

    @Test
    public void exercise1Test() {
        //        1. Open test site
        new IndexPage(driver).open();

        //        2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //        3. Perform login
        new PageObject(driver).login(USERNAME, PASSWORD);

        //        4. Assert Username
        assertEquals(new PageObject(driver).checkUsername(), "ROMAN IOVLEV");

        //        5. Assert that four head menu items with proper headers are displayed
        assertNotNull(new PageObject(driver).menuHeadTexts());
        List<String> menuHeadTexts = new PageObject(driver).menuHeadTexts();
        assertEquals(menuHeadTexts.size(), 4);
        assertEquals(menuHeadTexts.get(0), "HOME");
        assertEquals(menuHeadTexts.get(1), "CONTACT FORM");
        assertEquals(menuHeadTexts.get(2), "SERVICE");
        assertEquals(menuHeadTexts.get(3), "METALS & COLORS");

        //        6. Assert that there are 4 images on the Index Page and they are displayed
        assertEquals(new PageObject(driver).countBenefitIcons(), 4);

        //        7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertNotNull(new PageObject(driver).textUnderBenefitIcons());
        List<String> textUnderBenefitIcons = new PageObject(driver).textUnderBenefitIcons();
        assertEquals(textUnderBenefitIcons.size(), 4);
        assertEquals(textUnderBenefitIcons.get(0), "To include good practices\nand ideas from successful\n"
                + "EPAM project");
        assertEquals(textUnderBenefitIcons.get(1), "To be flexible and\ncustomizable");
        assertEquals(textUnderBenefitIcons.get(2), "To be multiplatform");
        assertEquals(textUnderBenefitIcons.get(3), "Already have good base\n(about 20 internal and\n"
                + "some external projects),\nwish to get more…");

        //        8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = new PageObject(driver).getIframe();

        //        9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(iframe);
        assertTrue(new PageObject(driver).existsFrameButton());

        //        10. Switch to original window back
        driver.switchTo().defaultContent();

        //        11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        //        (duplicate for step 5 except “Elements packs” section
        assertNotNull(new PageObject(driver).leftMenuItems());
        List<String> leftMenuItems = new PageObject(driver).leftMenuItems();
        assertEquals(leftMenuItems.size(), 5);
        assertEquals(leftMenuItems.get(0), "Home");
        assertEquals(leftMenuItems.get(1), "Contact form");
        assertEquals(leftMenuItems.get(2), "Service");
        assertEquals(leftMenuItems.get(3), "Metals & Colors");
        assertEquals(leftMenuItems.get(4), "Elements packs");
    }
}

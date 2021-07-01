package ru.training.at.hw4.failedtest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw4.BaseTest;

public class Exercise1Tests extends BaseTest {

    @Test
    public void exercise1Test() {
        //        1. Open test site
        actionStep.openIndexPage();

        //        2. Assert Browser title
        assertionStep.assertTitle("Home Page");

        //        3. Perform login
        actionStep.login(USERNAME, PASSWORD);

        //        4. Assert Username
        assertionStep.assertUsername("ROMAN IOVLEv");

        //        5. Assert that four menu items with proper headers are displayed
        //        Home
        assertionStep.assertHomeMenuHead("HOME");
        //        Contact form
        assertionStep.assertContactFormMenuHead("CONTACT FORM");
        //        Service
        assertionStep.assertServiceMenuHead("SERVICE");
        //        Metals & Colors
        assertionStep.assertMetalsAndColorsMenuHead("METALS & COLORS");

        //        6. Assert that there are 4 images on the Index Page and they are displayed
        //        Image 1
        assertionStep.findImage1Microscope();
        //        Image 2
        assertionStep.findImage2Headphones();
        //        Image 3
        assertionStep.findImage3Monitor();
        //        Image 4
        assertionStep.findImage4Rocket();

        //        7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //        Text 1
        assertionStep.assertTextUnderImage1Microscope("To include good practices\nand ideas from "
                + "successful\nEPAM project");
        //        Text 2
        assertionStep.assertTextUnderImage2Headphones("To be flexible and\ncustomizable");
        //        Text 3
        assertionStep.assertTextUnderImage3Monitor("To be multiplatform");
        //        Text 4
        assertionStep.assertTextUnderImage4Rocket("Already have good base\n(about 20 internal and\n"
                + "some external projects),\nwish to get more…");

        //        8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = assertionStep.findIframe();

        //        9. Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToIframe(iframe);
        assertionStep.findFrameButton();

        //        10. Switch to original window back
        actionStep.switchToMainContent();

        //        11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        //        (duplicate for step 5 except “Elements packs” section
        //        Home
        assertionStep.assertHomeMenuLeft("Home");
        //        Contact form
        assertionStep.assertContactFormMenuLeft("Contact form");
        //        Service
        assertionStep.assertServiceMenuLeft("Service");
        //        Metals & Colors
        assertionStep.assertMetalsAndColorsMenuLeft("Metals & Colors");
        //        Elements packs
        assertionStep.assertElementPacksMenuLeft("Elements packs");
    }
}

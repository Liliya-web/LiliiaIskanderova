package ru.training.at.hw3.ex1;

import static org.testng.Assert.assertEquals;

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

        //        5. Assert that four menu items with proper headers are displayed
        //        Home
        assertEquals(new PageObject(driver).checkHomeMenuHead(), "HOME");
        //        Contact form
        assertEquals(new PageObject(driver).checkContactFormMenuHead(), "CONTACT FORM");
        //        Service
        assertEquals(new PageObject(driver).checkServiceMenuHead(), "SERVICE");
        //        Metals & Colors
        assertEquals(new PageObject(driver).checkMetalsAndColorsMenuHead(), "METALS & COLORS");

        //        6. Assert that there are 4 images on the Index Page and they are displayed
        //        Image 1
        new PageObject(driver).image1Microscope();
        //        Image 2
        new PageObject(driver).image2Headphones();
        //        Image 3
        new PageObject(driver).image3Monitor();
        //        Image 4
        new PageObject(driver).image4Rocket();

        //        7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //        Text 1
        assertEquals(new PageObject(driver).textUnderImage1Microscope(),
            "To include good practices\nand ideas from successful\nEPAM project");
        //        Text 2
        assertEquals(new PageObject(driver).textUnderImage2Headphones(), "To be flexible and\ncustomizable");
        //        Text 3
        assertEquals(new PageObject(driver).textUnderImage3Monitor(), "To be multiplatform");
        //        Text 4
        assertEquals(new PageObject(driver).textUnderImage4Rocket(), "Already have good base\n(about 20 "
            + "internal and\nsome external projects),\nwish to get more…");

        //        8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = new PageObject(driver).getIframe();

        //        9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(iframe);
        new PageObject(driver).getFrameButton();

        //        10. Switch to original window back
        driver.switchTo().defaultContent();

        //        11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        //        Home
        assertEquals(new PageObject(driver).checkHomeMenuLeft(), "Home");
        //        Contact form
        assertEquals(new PageObject(driver).checkContactFormMenuLeft(), "Contact form");
        //        Service
        assertEquals(new PageObject(driver).checkServiceMenuLeft(), "Service");
        //        Metals & Colors
        assertEquals(new PageObject(driver).checkMetalsAndColorsMenuLeft(), "Metals & Colors");
        //        Elements packs
        assertEquals(new PageObject(driver).checkElementPacksMenuLeft(), "Elements packs");
    }
}

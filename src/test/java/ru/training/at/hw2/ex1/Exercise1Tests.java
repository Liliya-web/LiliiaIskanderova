package ru.training.at.hw2.ex1;

import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Exercise1Tests {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void exercise1Test() {
        //        1. Open test site
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        driver.navigate().to(url);

        //        2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //        3. Perform login
        WebElement openLoginField = driver.findElement(By.id("user-icon"));
        openLoginField.click();
        WebElement username = driver.findElement(By.id("name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("Roman");
        password.sendKeys("Jdi1234");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        //        4. Assert Username
        WebElement usernameDisplayed = driver.findElement(By.id("user-name"));
        assertEquals(usernameDisplayed.getText(), "ROMAN IOVLEV");

        //        5. Assert that four menu items with proper headers are displayed
        //        Home
        WebElement homeMenuHead =
            driver.findElement(By.xpath("//a[text()='Home']"));
        assertEquals(homeMenuHead.getText(), "HOME");
        //        Contact form
        WebElement contactFormMenuHead =
            driver.findElement(By.xpath("//a[text()='Contact form']"));
        assertEquals(contactFormMenuHead.getText(), "CONTACT FORM");
        //        Service xpath //a[text()=' Service '] isn't working
        WebElement servicesMenuHead =
            driver.findElement(By.cssSelector("a[data-toggle=\"dropdown\"]"));
        assertEquals(servicesMenuHead.getText(), "SERVICE");
        //        Metals & Colors
        WebElement metalsAndColorsMenuHead =
            driver.findElement(By.xpath("//a[text()='Metals & Colors']"));
        assertEquals(metalsAndColorsMenuHead.getText(), "METALS & COLORS");

        //        6. Assert that there are 4 images on the Index Page and they are displayed
        //        Image 1
        driver.findElement(
            By.xpath("//span[@class=\"icons-benefit icon-practise\"]"));
        //        Image 2
        driver.findElement(
            By.xpath("//span[@class=\"icons-benefit icon-custom\"]"));
        //        Image 3
        driver.findElement(
            By.xpath("//span[@class=\"icons-benefit icon-multi\"]"));
        //        Image 4
        driver.findElement(
            By.xpath("//span[@class=\"icons-benefit icon-multi\"]"));

        //        7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //        Text 1
        WebElement textUnderMicroscope =
            driver.findElement(
                By.xpath("//span[contains(text(), 'To include good practices')]"));
        assertEquals(textUnderMicroscope.getText(), "To include good practices\nand ideas from successful\n"
            + "EPAM project");
        //        Text 2
        WebElement textUnderHeadphones =
            driver.findElement(By.xpath("//span[contains(text(), 'To be flexible')]"));
        assertEquals(textUnderHeadphones.getText(), "To be flexible and\ncustomizable");
        //        Text 3
        WebElement textUnderMonitor =
            driver.findElement(
                By.xpath("//span[contains(text(), 'To be multiplatform')]"));
        assertEquals(textUnderMonitor.getText(), "To be multiplatform");
        //        Text 4
        WebElement textUnderRocket = driver.findElement(
            By.xpath("//span[contains(text(), 'Already have good base')]"));
        assertEquals(textUnderRocket.getText(), "Already have good base\n(about 20 internal and\n"
            + "some external projects),\nwish to get more…");

        //        8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.id("frame"));

        //        9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("frame-button"));

        //        10. Switch to original window back
        driver.switchTo().defaultContent();
        WebElement mainContent = driver.findElement(By.cssSelector("div[class=\"main-content\"]"));
        mainContent.click();

        //        11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        //        (duplicate for step 5 except “Elements packs” section
        //        Home
        WebElement homeMenuLeft =
            driver.findElement(By.xpath("//span[text()='Home']"));
        assertEquals(homeMenuLeft.getText(), "Home");
        //        Contact form
        WebElement contactFormMenuLeft =
            driver.findElement(By.xpath("//span[text()='Contact form']"));
        assertEquals(contactFormMenuLeft.getText(), "Contact form");
        //        Service
        WebElement serviceMenuLeft =
            driver.findElement(By.xpath("//span[text()='Service']"));
        assertEquals(serviceMenuLeft.getText(), "Service");
        //        Metals & Colors
        WebElement metalsAndColorsMenuLeft =
            driver.findElement(By.xpath("//span[text()='Metals & Colors']"));
        assertEquals(metalsAndColorsMenuLeft.getText(), "Metals & Colors");
        //        Elements packs
        WebElement elementsPacksMenuLeft =
            driver.findElement(By.xpath("//span[text()='Elements packs']"));
        assertEquals(elementsPacksMenuLeft.getText(), "Elements packs");
    }
}

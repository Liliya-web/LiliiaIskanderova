package ru.training.at.hw2.ex2;

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

public class Exercise2Tests {

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
    public void exercise2Test() {
        //        1. Open test site
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

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

        //        5. Open through the header menu Service -> Different Elements Page
        WebElement serviceMenu =
            driver.findElement(By.cssSelector("[class=\"uui-header dark-gray\"] a[class=\"dropdown-toggle\"]"));
        serviceMenu.click();
        WebElement differentElementsMenu =
            driver.findElement(By.cssSelector(
                "ul[class=\"uui-navigation nav navbar-nav m-l8\"]  a[href=\"different-elements.html\"]"));
        differentElementsMenu.click();

        //        6. Select checkboxes Water, Wind
        WebElement waterCheckbox =
            driver
                .findElement(By.cssSelector("div[class=\"checkbox-row\"] > label:nth-child(1) > input[type=checkbox]"));
        waterCheckbox.click();
        WebElement windCheckbox =
            driver
                .findElement(By.cssSelector("div[class=\"checkbox-row\"] > label:nth-child(3) > input[type=checkbox]"));
        windCheckbox.click();

        //        7. Select radio Selen
        WebElement selenRadio =
            driver.findElement(By.cssSelector("div[class=\"checkbox-row\"] > label:nth-child(4) > input[type=radio]"));
        selenRadio.click();

        //        8. Select in dropdown Yellow
        WebElement dropdown =
            driver.findElement(By.cssSelector("div[class=\"colors\"] > select[class=\"uui-form-element\"]"));
        dropdown.click();
        WebElement yellow =
            driver.findElement(By.xpath("//option[text()='Yellow']"));
        yellow.click();

        //        9. Assert that:
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //    • for radio button there is a log row and value is corresponded to the status of radio button
        //    • for dropdown there is a log row and value is corresponded to the selected value
        //        Yellow
        WebElement colors =
            driver.findElement(By.xpath("//li[contains(text(), 'Colors: value changed to Yellow')]"));
        String colorsText = colors.getText().substring(9);
        assertEquals(colorsText, "Colors: value changed to Yellow");
        //        Selen - little bag. "Metal" does not start with the capital letter
        //        also xpath finding by text isn't working
        WebElement metal = driver.findElement(By.cssSelector("ul[class=\"panel-body-list logs\"] > li:nth-child(2)"));
        String metalText = metal.getText().substring(9);
        assertEquals(metalText, "metal: value changed to Selen");
        //        Wind
        WebElement wind = driver.findElement(By.xpath("//li[contains(text(), 'Wind: condition changed to true')]"));
        String windText = wind.getText().substring(9);
        assertEquals(windText, "Wind: condition changed to true");
        //        Water
        WebElement water = driver.findElement(By.xpath("//li[contains(text(), 'Water: condition changed to true')]"));
        String waterText = water.getText().substring(9);
        assertEquals(waterText, "Water: condition changed to true");
    }
}

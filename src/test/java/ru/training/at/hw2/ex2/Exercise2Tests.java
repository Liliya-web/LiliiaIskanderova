package ru.training.at.hw2.ex2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise2Tests {

    private WebDriver driver;
    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String USERNAME = "Roman";
    private static final String PASSWORD = "Jdi1234";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void exercise2Test() {
        //        1. Open test site
        driver.navigate().to(URL);

        //        2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //        3. Perform login
        WebElement openLoginField = driver.findElement(By.id("user-icon"));
        openLoginField.click();
        WebElement username = driver.findElement(By.id("name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys(USERNAME);
        password.sendKeys(PASSWORD);
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        //        4. Assert Username
        WebElement usernameDisplayed = driver.findElement(By.id("user-name"));
        assertEquals(usernameDisplayed.getText(), "ROMAN IOVLEV");

        //        5. Open through the header menu Service -> Different Elements Page
        WebElement serviceMenu = driver.findElement(By.cssSelector("a[data-toggle=\"dropdown\"]"));
        serviceMenu.click();
        WebElement differentElementsMenu = driver.findElement(By.xpath("//a[text()='Different elements']"));
        differentElementsMenu.click();

        //        6. Select checkboxes Water, Wind
        WebElement waterCheckbox = driver.findElement(By.cssSelector("label:nth-child(1) > input[type=checkbox]"));
        waterCheckbox.click();
        WebElement windCheckbox = driver.findElement(By.cssSelector("label:nth-child(3) > input[type=checkbox]"));
        windCheckbox.click();

        //        7. Select radio Selen
        WebElement selenRadio = driver.findElement(By.cssSelector("label:nth-child(4) > input[type=radio]"));
        selenRadio.click();

        //        8. Select in dropdown Yellow
        WebElement dropdown = driver.findElement(By.cssSelector("select[class=\"uui-form-element\"]"));
        dropdown.click();
        WebElement yellow = driver.findElement(By.xpath("//option[text()='Yellow']"));
        yellow.click();

        //        9. Assert that:
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //    • for radio button there is a log row and value is corresponded to the status of radio button
        //    • for dropdown there is a log row and value is corresponded to the selected value
        //        Yellow
        WebElement colors = driver.findElement(By.xpath("//li[contains(text(), 'Yellow')]"));
        assertTrue(colors.getText().contains("Colors: value changed to Yellow"));
        //        Selen - little bag. "Metal" does not start with the capital letter
        WebElement metal = driver.findElement(By.xpath("//li[contains(text(), 'Selen')]"));
        assertTrue(metal.getText().contains("metal: value changed to Selen"));
        //        Wind
        WebElement wind = driver.findElement(By.xpath("//li[contains(text(), 'Wind')]"));
        assertTrue(wind.getText().contains("Wind: condition changed to true"));
        //        Water
        WebElement water = driver.findElement(By.xpath("//li[contains(text(), 'Water')]"));
        assertTrue(water.getText().contains("Water: condition changed to true"));
    }
}

package ru.training.at.hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw6.driver.WebDriverSingleton;
import ru.training.at.hw6.steps.ActionStep;
import ru.training.at.hw6.steps.AssertionStep;

public class BaseTest {
    protected WebDriver driver;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;
    protected PageObject pageObject;
    protected static final String USERNAME = "Roman";
    protected static final String PASSWORD = "Jdi1234";

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        driver = WebDriverSingleton.getDriver();
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        pageObject = new PageObject(driver);
        testContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}

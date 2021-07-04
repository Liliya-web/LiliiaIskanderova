package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.PageObject;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.driver.WebDriverSingleton;

public class CucumberHook {
    protected WebDriver driver;
    protected PageObject pageObject;
    protected static final String USERNAME = "Roman";
    protected static final String PASSWORD = "Jdi1234";

    @Before
    public void setUp() {
        WebDriverSingleton.getDriver();
        pageObject = new PageObject(driver);
    }

    @After
    public void tearDown() {
        WebDriverSingleton.closeDriver();
        TestContext.getInstance().clean();
    }
}

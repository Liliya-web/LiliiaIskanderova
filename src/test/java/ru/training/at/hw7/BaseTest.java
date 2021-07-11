package ru.training.at.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.reload;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import ru.training.at.hw7.listeners.TestNGListener;
import ru.training.at.hw7.site.SiteJdi;
import ru.training.at.hw7.steps.MainSteps;
import ru.training.at.hw7.steps.PreconditionSteps;

@Listeners(TestNGListener.class)
public class BaseTest extends TestNGListener {
    protected MainSteps mainSteps;

    public BaseTest() {
        mainSteps = new MainSteps();
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initSite(SiteJdi.class);
        SiteJdi.homePage.open();
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        killAllSeleniumDrivers();
    }

    @BeforeMethod
    public void login() {
        PreconditionSteps.shouldBeLoggedIn();
    }

    @AfterMethod
    public void refreshPageOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            reload();
        }
    }
}

package ru.training.at.hw6.driver;

import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        String driverType = System.getProperty("driver.type") == null ? "local" : System.getProperty("driver.type");
        String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        if (Objects.isNull(driver)) {
            driver = WebDriverFactory.createWebDriver(driverType, browserName);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver = null;
    }
}

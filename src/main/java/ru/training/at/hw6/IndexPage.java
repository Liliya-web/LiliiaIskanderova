package ru.training.at.hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage extends AbstractComponent {
    private static final String INDEX_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.navigate().to(INDEX_URL);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void switchToIframe(WebElement iframe) {
        driver.switchTo().frame(iframe);
    }

    public void switchToMainContent() {
        driver.switchTo().defaultContent();
    }

}

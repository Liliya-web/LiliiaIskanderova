package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;

public class IndexPage extends AbstractComponent {
    private static final String INDEX_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.navigate().to(INDEX_URL);
    }
}

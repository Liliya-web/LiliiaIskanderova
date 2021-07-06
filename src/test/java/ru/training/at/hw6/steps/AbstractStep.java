package ru.training.at.hw6.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.IndexPage;
import ru.training.at.hw6.PageObject;

public abstract class AbstractStep {

    protected IndexPage indexPage;
    protected PageObject pageObject;

    protected AbstractStep(WebDriver driver) {
        indexPage = new IndexPage(driver);
        pageObject = new PageObject(driver);
    }

    @Step("Open index page")
    public void openIndexPage() {
        indexPage.open();
    }
}

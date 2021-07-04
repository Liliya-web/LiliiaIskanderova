package ru.training.at.hw5.steps;

import ru.training.at.hw5.IndexPage;
import ru.training.at.hw5.PageObject;
import ru.training.at.hw5.driver.WebDriverSingleton;

public class AbstractStep {
    protected IndexPage indexPage;
    protected PageObject pageObject;
    protected static final String USERNAME = "Roman";
    protected static final String PASSWORD = "Jdi1234";

    protected AbstractStep() {
        indexPage = new IndexPage(WebDriverSingleton.getDriver());
        pageObject = new PageObject(WebDriverSingleton.getDriver());
    }
}

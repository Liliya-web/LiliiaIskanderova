package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionStep extends AbstractStep {
    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Perform login")
    public void login(String username, String password) {
        pageObject.login(username, password);
    }

    @Step("Switching to iframe")
    public void switchToIframe(WebElement iframe) {
        indexPage.switchToIframe(iframe);
    }

    @Step("Switching to main content")
    public void switchToMainContent() {
        indexPage.switchToMainContent();
    }

    @Step("Opening Services > Different Elements through head menu")
    public void clickOnServicesDifferentElementsMenuHead() {
        pageObject.clickOnServicesDifferentElementsMenuHead();
    }

    @Step("Select Water checkbox")
    public void selectWaterCheckbox() {
        pageObject.selectWaterCheckbox();
    }

    @Step("Select Wind checkbox")
    public void selectWindCheckbox() {
        pageObject.selectWindCheckbox();
    }

    @Step("Select radio Selen")
    public void selectSelenRadio() {
        pageObject.selectSelenRadio();
    }

    @Step("Select Yellow color in dropdown")
    public void selectYellowInDropdown() {
        pageObject.selectYellowInDropdown();
    }
}

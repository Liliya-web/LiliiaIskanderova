package ru.training.at.hw4.steps;

import static org.testng.Assert.assertEquals;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Assert Browser title")
    public void assertTitle(String expectedTitle) {
        assertEquals(indexPage.getTitle(), expectedTitle);
    }

    @Step("Assert Username")
    public void assertUsername(String expectedUsername) {
        assertEquals(pageObject.checkUsername(), expectedUsername);
    }

    @Step("Assert head Home menu item")
    public void assertHomeMenuHead(String expectedText) {
        assertEquals(pageObject.checkHomeMenuHead(), expectedText);
    }

    @Step("Assert head Contact Form menu item")
    public void assertContactFormMenuHead(String expectedText) {
        assertEquals(pageObject.checkContactFormMenuHead(), expectedText);
    }

    @Step("Assert head Service menu item")
    public void assertServiceMenuHead(String expectedText) {
        assertEquals(pageObject.checkServiceMenuHead(), expectedText);
    }

    @Step("Assert head MetalsAndColors menu item")
    public void assertMetalsAndColorsMenuHead(String expectedText) {
        assertEquals(pageObject.checkMetalsAndColorsMenuHead(), expectedText);
    }

    @Step("Assert existence image1 Microscope")
    public WebElement findImage1Microscope() {
        return pageObject.image1Microscope();
    }

    @Step("Assert existence image2 Headphones")
    public WebElement findImage2Headphones() {
        return pageObject.image2Headphones();
    }

    @Step("Assert existence image3 Monitor")
    public WebElement findImage3Monitor() {
        return pageObject.image3Monitor();
    }

    @Step("Assert existence image4 Rocket")
    public WebElement findImage4Rocket() {
        return pageObject.image4Rocket();
    }

    @Step("Assert text under image1 Microscope")
    public void assertTextUnderImage1Microscope(String expectedText) {
        assertEquals(pageObject.textUnderImage1Microscope(), expectedText);
    }

    @Step("Assert text under image2 Headphones")
    public void assertTextUnderImage2Headphones(String expectedText) {
        assertEquals(pageObject.textUnderImage2Headphones(), expectedText);
    }

    @Step("Assert text under image3 Monitor")
    public void assertTextUnderImage3Monitor(String expectedText) {
        assertEquals(pageObject.textUnderImage3Monitor(), expectedText);
    }

    @Step("Assert text under image4 Rocket")
    public void assertTextUnderImage4Rocket(String expectedText) {
        assertEquals(pageObject.textUnderImage4Rocket(), expectedText);
    }

    @Step("Assert existence of iframe")
    public WebElement findIframe() {
        return pageObject.getIframe();
    }

    @Step("Assert existence of frame-button")
    public WebElement findFrameButton() {
        return pageObject.getFrameButton();
    }

    @Step("Assert left Home menu item")
    public void assertHomeMenuLeft(String expectedText) {
        assertEquals(pageObject.checkHomeMenuLeft(), expectedText);
    }

    @Step("Assert left Contact Form menu item")
    public void assertContactFormMenuLeft(String expectedText) {
        assertEquals(pageObject.checkContactFormMenuLeft(), expectedText);
    }

    @Step("Assert left Service menu item")
    public void assertServiceMenuLeft(String expectedText) {
        assertEquals(pageObject.checkServiceMenuLeft(), expectedText);
    }

    @Step("Assert left MetalsAndColors menu item")
    public void assertMetalsAndColorsMenuLeft(String expectedText) {
        assertEquals(pageObject.checkMetalsAndColorsMenuLeft(), expectedText);
    }

    @Step("Assert left Element Packs menu item")
    public void assertElementPacksMenuLeft(String expectedText) {
        assertEquals(pageObject.checkElementPacksMenuLeft(), expectedText);
    }
}

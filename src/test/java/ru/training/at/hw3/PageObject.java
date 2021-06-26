package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    public PageObject(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "user-icon")
    private WebElement openLoginField;
    @FindBy(id = "name")
    private WebElement getUsername;
    @FindBy(id = "password")
    private WebElement getPassword;
    @FindBy(id = "login-button")
    private WebElement getLoginButton;
    @FindBy(id = "user-name")
    private WebElement getUsernameDisplayed;
    @FindBy(xpath = "//a[text()='Home']")
    private WebElement getHomeMenuHead;
    @FindBy(xpath = "//a[text()='Contact form']")
    private WebElement getContactFormMenuHead;
    @FindBy(css = "a[data-toggle=\"dropdown\"]")
    private WebElement getServicesMenuHead;
    @FindBy(xpath = "//a[text()='Metals & Colors']")
    private WebElement getMetalsAndColorsMenuHead;
    @FindBy(xpath = "//span[@class=\"icons-benefit icon-practise\"]")
    private WebElement getImage1Microscope;
    @FindBy(xpath = "//span[@class=\"icons-benefit icon-custom\"]")
    private WebElement getImage2Headphones;
    @FindBy(xpath = "//span[@class=\"icons-benefit icon-multi\"]")
    private WebElement getImage3Monitor;
    @FindBy(xpath = "//span[@class=\"icons-benefit icon-base\"]")
    private WebElement getImage4Rocket;
    @FindBy(xpath = "//span[contains(text(), 'To include good practices')]")
    private WebElement getTextUnderImage1Microscope;
    @FindBy(xpath = "//span[contains(text(), 'To be flexible')]")
    private WebElement getTextUnderImage2Headphones;
    @FindBy(xpath = "//span[contains(text(), 'To be multiplatform')]")
    private WebElement getTextUnderImage3Monitor;
    @FindBy(xpath = "//span[contains(text(), 'Already have good base')")
    private WebElement getTextUnderImage4Rocket;
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "frame-button")
    private WebElement getFrameButton;
    @FindBy(xpath = "//span[text()='Home']")
    private WebElement getHomeMenuLeft;
    @FindBy(xpath = "//span[text()='Contact form']")
    private WebElement getContactFormMenuLeft;
    @FindBy(xpath = "//span[text()='Service']")
    private WebElement getServiceMenuLeft;
    @FindBy(xpath = "//span[text()='Metals & Colors']")
    private WebElement getMetalsAndColorsMenuLeft;
    @FindBy(xpath = "//span[text()='Elements packs']")
    private WebElement getElementsPacksMenuLeft;
    @FindBy(xpath = "//a[text()='Different elements']")
    private WebElement getServiceDifferentElementsMenuHead;
    @FindBy(css = "label:nth-child(1) > input[type=checkbox]")
    private WebElement getWaterCheckbox;
    @FindBy(css = "label:nth-child(3) > input[type=checkbox]")
    private WebElement getWindCheckbox;
    @FindBy(css = "label:nth-child(4) > input[type=radio]")
    private WebElement getSelenRadio;
    @FindBy(css = "select[class=\"uui-form-element\"]")
    private WebElement dropdown;
    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement getYellowColor;
    @FindBy(xpath = "//li[contains(text(), 'Yellow')]")
    private WebElement log1Colors;
    @FindBy(xpath = "//li[contains(text(), 'Selen')]")
    private WebElement log2Metal;
    @FindBy(xpath = "//li[contains(text(), 'Wind')]")
    private WebElement log3Wind;
    @FindBy(xpath = "Water: condition changed to true")
    private WebElement log4Water;

    public PageObject() {
    }

    //    ex1 and ex 2

    public void login(String name, String password) {
        openLoginField.click();
        getUsername.click();
        getUsername.sendKeys(name);
        getPassword.click();
        getPassword.sendKeys(password);
        getLoginButton.click();
    }

    public String checkUsername() {
        return getUsernameDisplayed.getText();
    }

    //    ex1
    public String checkHomeMenuHead() {
        return getHomeMenuHead.getText();
    }

    public String checkContactFormMenuHead() {
        return getContactFormMenuHead.getText();
    }

    public String checkServiceMenuHead() {
        return getServicesMenuHead.getText();
    }

    public String checkMetalsAndColorsMenuHead() {
        return getMetalsAndColorsMenuHead.getText();
    }

    public WebElement image1Microscope() {
        return getImage1Microscope;
    }

    public WebElement image2Headphones() {
        return getImage2Headphones;
    }

    public WebElement image3Monitor() {
        return getImage3Monitor;
    }

    public WebElement image4Rocket() {
        return getImage4Rocket;
    }

    public String textUnderImage1Microscope() {
        return getTextUnderImage1Microscope.getText();
    }

    public String textUnderImage2Headphones() {
        return getTextUnderImage2Headphones.getText();
    }

    public String textUnderImage3Monitor() {
        return getTextUnderImage3Monitor.getText();
    }

    public String textUnderImage4Rocket() {
        return getTextUnderImage4Rocket.getText();
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getFrameButton() {
        return getFrameButton;
    }

    public String checkHomeMenuLeft() {
        return getHomeMenuLeft.getText();
    }

    public String checkContactFormMenuLeft() {
        return getContactFormMenuLeft.getText();
    }

    public String checkServiceMenuLeft() {
        return getServiceMenuLeft.getText();
    }

    public String checkMetalsAndColorsMenuLeft() {
        return getMetalsAndColorsMenuLeft.getText();
    }

    public String checkElementPacksMenuLeft() {
        return getElementsPacksMenuLeft.getText();
    }

    // ex2

    public void clickOnServicesDifferentElementsMenuHead() {
        getServicesMenuHead.click();
        getServiceDifferentElementsMenuHead.click();
    }

    public void selectWaterCheckBox() {
        getWaterCheckbox.click();
    }

    public void selectWindCheckbox() {
        getWindCheckbox.click();
    }

    public void selectSelenRadio() {
        getSelenRadio.click();
    }

    public void selectYellowInDropdown() {
        dropdown.click();
        getYellowColor.click();
    }

    public String log1Color() {
        return log1Colors.getText();
    }

    public String log2Metal() {
        return log2Metal.getText();
    }

    public String log3Wind() {
        return log3Wind.getText();
    }

    public String log4Water() {
        return log4Water.getText();
    }

}

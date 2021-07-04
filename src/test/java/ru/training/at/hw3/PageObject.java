package ru.training.at.hw3;

import java.util.ArrayList;
import java.util.List;
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
    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li/a")
    private List<WebElement> getMenuHeadItems;
    @FindBy(css = "div.benefit-icon")
    private List<WebElement> getBenefitIcons;
    @FindBy(css = "span.benefit-txt")
    private List<WebElement> getTextUnderBenefitIcons;
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "frame-button")
    private List<WebElement> getFrameButtons;
    @FindBy(xpath = "//ul[contains(@class, 'left')]/li/a/span")
    private List<WebElement> getLeftMenuItems;
    @FindBy(xpath = "//a[text()='Different elements']")
    private WebElement getServiceDifferentElementsMenuHead;
    @FindBy(css = "input[type=checkbox]")
    private List<WebElement> getCheckboxes;
    @FindBy(css = "input[type=radio]")
    private List<WebElement> getRadios;
    @FindBy(css = "select[class=\"uui-form-element\"]")
    private WebElement dropdown;
    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement getYellowColor;
    @FindBy(css = "ul[class=\"panel-body-list logs\"] > li")
    private List<WebElement> getLogTexts;

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
    public List<String> menuHeadTexts() {
        List<String> result = new ArrayList<>();
        if (getMenuHeadItems.size() > 0) {
            for (WebElement elem :
                    getMenuHeadItems) {
                result.add(elem.getText());
            }
        }
        return result;
    }

    public int countBenefitIcons() {
        return getBenefitIcons.size();
    }

    public List<String> textUnderBenefitIcons() {
        List<String> result = new ArrayList<>();
        if (getTextUnderBenefitIcons.size() > 0) {
            for (WebElement elem :
                    getTextUnderBenefitIcons) {
                result.add(elem.getText());
            }
        }
        return result;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public boolean existsFrameButton() {
        return getFrameButtons.size() > 0;
    }

    public List<String> leftMenuItems() {
        List<String> result = new ArrayList<>();
        if (getLeftMenuItems.size() > 0) {
            for (WebElement elem :
                    getLeftMenuItems) {
                result.add(elem.getText());
            }
        }
        return result;
    }

    // ex2

    public void clickOnServicesDifferentElementsMenuHead() {
        getMenuHeadItems.get(2).click(); // click Service dropdown on the head menu
        getServiceDifferentElementsMenuHead.click();
    }

    public void selectWaterCheckBox() {
        if (getCheckboxes.size() > 0) {
            getCheckboxes.get(0).click();
        }
    }

    public void selectWindCheckbox() {
        if (getCheckboxes.size() >= 3) {
            getCheckboxes.get(2).click();
        }
    }

    public void selectSelenRadio() {
        if (getRadios.size() >= 4) {
            getRadios.get(3).click();
        }
    }

    public void selectYellowInDropdown() {
        dropdown.click();
        getYellowColor.click();
    }

    public List<String> logTexts() {
        List<String> result = new ArrayList<>();
        if (getLogTexts.size() > 0) {
            for (WebElement elem :
                    getLogTexts) {
                result.add(elem.getText());
            }
        }
        return result;
    }

}

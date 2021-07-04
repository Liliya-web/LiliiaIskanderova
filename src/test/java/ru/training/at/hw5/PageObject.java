package ru.training.at.hw5;

import static org.testng.Assert.assertEquals;

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
    @FindBy(css = "ul.dropdown-menu > li > a")
    private List<WebElement> getServiceMenuHeadItems;
    @FindBy(css = "#user-table td:nth-child(1)")
    public List<WebElement> getUserTableNumbers;
    @FindBy(css = "#user-table select")
    public List<WebElement> getUserTableDropdowns;
    @FindBy(css = "#user-table tr:nth-child(1) option")
    public List<WebElement> getUserTableDropdownValues;
    @FindBy(css = "#user-table a")
    public List<WebElement> getUserTableUsernames;
    @FindBy(css = "#user-table span")
    public List<WebElement> getUserTableDescriptionsUnderImages;
    @FindBy(css = "#user-table input")
    public List<WebElement> getUserTableCheckboxes;
    @FindBy(css = "#user-table th")
    public List<WebElement> getUserTableHeaders;
    @FindBy(xpath = "//ul[contains(@class, 'log')]/li")
    public List<WebElement> getLogMessages;

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

    public void clickOnServiceMenuHead() {
        getMenuHeadItems.get(2).click();
    }

    public void clickOnDifferentElementsMenuHead() {
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

    public void clickOnUserTableMenuHead() {
        getServiceMenuHeadItems.get(5).click();
    }

    public int countUserTableDropdowns() {
        return getUserTableDropdowns.size();
    }

    public int countUserTableUsernames() {
        return getUserTableDropdowns.size();
    }

    public int countUserTableDescriptionsUnderImages() {
        return getUserTableDescriptionsUnderImages.size();
    }

    public int countUserTableCheckboxes() {
        return getUserTableCheckboxes.size();
    }

    public <T> void  tableValuesChecker(List<WebElement> actualValues, List<String> expectedValues) {
        for (int i = 0; i < actualValues.size(); i++) {
            assertEquals(actualValues.get(i).getText(), expectedValues.get(i));
        }
    }

    public void clickOnUserTableVipCheckboxForSergeyIvan() {
        getUserTableCheckboxes.get(1).click();
    }

    public int countLogMessages() {
        return getLogMessages.size();
    }

    public String checkFirstLogMessage() {
        return getLogMessages.get(0).getText();
    }
}

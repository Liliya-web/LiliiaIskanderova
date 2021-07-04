package ru.training.at.hw5.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class ThenStep extends AbstractStep {

    @Then("log row for Water checkbox is displayed and it's condition changed to true")
    public void checkLogWaterText() {
        assertTrue(pageObject.logTexts().get(3).contains("Water: condition changed to true"));
    }

    @Then("log row for Wind checkbox is displayed and it's condition changed to true")
    public void checkLogWindText() {
        assertTrue(pageObject.logTexts().get(2).contains("Wind: condition changed to true"));
    }

    @Then("log row for Selen radio is displayed and it's condition changed to true")
    public void checkLogSelenText() {
        assertTrue(pageObject.logTexts().get(1).contains("metal: value changed to Selen"));
    }

    @Then("log row for Yellow color in dropdown is displayed and it's condition changed to true")
    public void checkLogYellowDropdownText() {
        assertTrue(pageObject.logTexts().get(0).contains("Colors: value changed to Yellow"));
    }

    @Then("\"User Table\" page should be opened")
    public void checkIfUserTableIsOpened() {
        assertEquals(indexPage.getTitle(), "User Table");
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void countUsersTableDropdowns() {
        assertEquals(pageObject.countUserTableDropdowns(), 6);
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void countUsersTableUsernames() {
        assertEquals(pageObject.countUserTableUsernames(), 6);
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void countUsersTableDescriptionsUnderImages() {
        assertEquals(pageObject.countUserTableDescriptionsUnderImages(), 6);
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void countUsersTableCheckboxes() {
        assertEquals(pageObject.countUserTableCheckboxes(), 6);
    }

    public void  tableValuesChecker(List<WebElement> actualValues, List<String> expectedValues) {
        for (int i = 0; i < actualValues.size(); i++) {
            assertEquals(actualValues.get(i).getText(), expectedValues.get(i));
        }
    }
    
    @Then("User table should contain following values:")
    public void checkUserTableValues(DataTable dataTable) {
        List<WebElement> userTableHeadersActual = pageObject.getUserTableHeaders;
        List<String> userTableHeadersExpected = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            userTableHeadersExpected.add(dataTable.cell(0, i));
        }
        userTableHeadersExpected.add(1, "Type");
        tableValuesChecker(userTableHeadersActual, userTableHeadersExpected);

        List<WebElement> userTableNumbersActual = pageObject.getUserTableNumbers;
        List<String> userTableNumbersExpected = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            userTableNumbersExpected.add(dataTable.cell(i, 0));
        }
        tableValuesChecker(userTableNumbersActual, userTableNumbersExpected);

        List<WebElement> userTableUsernamesActual = pageObject.getUserTableUsernames;
        List<String> userTableUsernamesExpected = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            userTableUsernamesExpected.add(dataTable.cell(i, 1));
        }
        tableValuesChecker(userTableUsernamesActual, userTableUsernamesExpected);

        List<WebElement> userTableDescriptionsActual = pageObject.getUserTableDescriptionsUnderImages;
        List<String> userTableDescriptionsExpected = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            userTableDescriptionsExpected.add(dataTable.cell(i, 2));
        }
        tableValuesChecker(userTableDescriptionsActual, userTableDescriptionsExpected);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkUserTableDropdownValues(DataTable dataTable) {
        List<WebElement> userTableDropdownValuesActual = pageObject.getUserTableDropdownValues;
        List<String> userTableDropdownValuesExpected = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            userTableDropdownValuesExpected.add(dataTable.cell(i, 0));
        }
        tableValuesChecker(userTableDropdownValuesActual, userTableDropdownValuesExpected);
    }

    @Then("1 log row has {string} text in log section")
    public void checkLogText(String expectedText) {
        assertEquals(pageObject.countLogMessages(), 1);
        assertTrue(pageObject.checkFirstLogMessage().contains(expectedText));
    }
}

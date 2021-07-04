package ru.training.at.hw5.steps;

import io.cucumber.java.en.When;

public class WhenStep extends AbstractStep {

    @When("I click on \"Service\" button in Header")
    public void clickOnServiceMenuHead() {
        pageObject.clickOnServiceMenuHead();
    }

    @When("I click on Different Elements Page in Header")
    public void clickOnDifferentElementsMenuHead() {
        pageObject.clickOnDifferentElementsMenuHead();
    }

    @When("I select Water checkbox")
    public void selectWaterCheckbox() {
        pageObject.selectWaterCheckBox();
    }

    @When("I select Wind checkbox")
    public void selectWindCheckbox() {
        pageObject.selectWindCheckbox();
    }

    @When("I select Selen radio")
    public void selectSelenRadio() {
        pageObject.selectSelenRadio();
    }

    @When("I select Yellow in dropdown")
    public void selectYellowInDropdown() {
        pageObject.selectYellowInDropdown();
    }

    @When("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableMenuHead() {
        pageObject.clickOnUserTableMenuHead();
    }

    @When("I select \"Vip\" checkbox for \"Sergey Ivan\"")
    public void clickOnVipCheckboxForSergeyIvan() {
        pageObject.clickOnUserTableVipCheckboxForSergeyIvan();
    }
}

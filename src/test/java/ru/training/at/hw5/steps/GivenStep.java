package ru.training.at.hw5.steps;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openJdiHomePage() {
        indexPage.open();
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void logIn() {
        pageObject.login(USERNAME, PASSWORD);
        assertEquals(pageObject.checkUsername(), USERNAME_DISPLAYED);
    }
}

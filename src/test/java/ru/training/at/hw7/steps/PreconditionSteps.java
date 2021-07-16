package ru.training.at.hw7.steps;

import io.qameta.allure.Step;
import ru.training.at.hw7.entities.User;
import ru.training.at.hw7.site.SiteJdi;

public class PreconditionSteps {
    @Step("Check if logged in and login")
    public static void shouldBeLoggedIn() {
        SiteJdi.homePage.shouldBeOpened();
        if (!SiteJdi.userName.isDisplayed()) {
            login();
        }
    }

    @Step("Login")
    public static void login() {
        SiteJdi.profilePhoto.click();
        SiteJdi.loginForm.submit(new User(), "enter");
        SiteJdi.userName.is().displayed();
    }
}

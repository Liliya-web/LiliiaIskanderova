package ru.training.at.hw7.site;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import ru.training.at.hw7.site.pages.HomePage;
import ru.training.at.hw7.site.pages.MetalsAndColorsPage;
import ru.training.at.hw7.site.sections.LoginForm;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;
    @Css("form") public static LoginForm loginForm;
    @Css(".profile-photo") public static Button profilePhoto;
    @Css(".profile-photo [ui=label]") public static UIElement userName;
    @ByText("Metals & Colors") public static UIElement metalsAndColorsMenuHead;
}

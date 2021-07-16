package ru.training.at.hw7.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.util.List;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    @UI("p.radio") public static RadioButtons summaryRadio;
    @Css("p.checkbox") public static List<Checkbox> elementsCheckboxes;
    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown colorsDropdown;
    @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    public static Dropdown metalsDropdown;
    @JDropdown(root = "div[ui=droplist]", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown vegetablesDropdown;
    @ByText("Submit") public static Button submitButton;
    @Css(".summ-res") public static UIElement summaryResult;
    @Css(".col-res") public static UIElement colorResult;
    @Css(".met-res") public static UIElement metalResult;
    @Css(".sal-res") public static UIElement vegetablesResult;
    @Css(".elem-res") public static UIElement elementsResult;
}

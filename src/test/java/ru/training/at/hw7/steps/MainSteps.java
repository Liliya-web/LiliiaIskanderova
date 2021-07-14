package ru.training.at.hw7.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static ru.training.at.hw7.site.SiteJdi.metalsAndColorsMenuHead;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.colorResult;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.colorsDropdown;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.elementsCheckboxes;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.elementsResult;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.metalResult;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.metalsDropdown;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.submitButton;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.summaryRadio;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.summaryResult;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.vegetablesDropdown;
import static ru.training.at.hw7.site.pages.MetalsAndColorsPage.vegetablesResult;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import io.qameta.allure.Step;
import java.util.List;

public class MainSteps {
    @Step("Open Metals and Colors page")
    public void openMetalsAndColorsPage() {
        metalsAndColorsMenuHead.click();
    }

    @Step("Submit Metals and Colors form")
    public void submitMetalsAndColorsForm(List<Double> summary, List<String> elements,
                                          String color, String metal, List<String> vegetables) {
        if (summaryRadio != null) {
            IList<UIElement> summaryList = summaryRadio.list();
            if (summary.contains(1.0)) {
                summaryList.get(0).click();
            }
            if (summary.contains(2.0)) {
                summaryList.get(4).click();
            }
            if (summary.contains(3.0)) {
                summaryList.get(1).click();
            }
            if (summary.contains(4.0)) {
                summaryList.get(5).click();
            }
            if (summary.contains(5.0)) {
                summaryList.get(2).click();
            }
            if (summary.contains(6.0)) {
                summaryList.get(6).click();
            }
            if (summary.contains(7.0)) {
                summaryList.get(3).click();
            }
            if (summary.contains(8.0)) {
                summaryList.get(7).click();
            }
        }

        if (elementsCheckboxes != null) {
            for (Checkbox value : elementsCheckboxes) {
                if (elements.contains(value.label().getValue())) {
                    value.click();
                }
            }
        }

        selectInDropdown(colorsDropdown, color);
        selectInDropdown(metalsDropdown, metal);

        if (vegetablesDropdown != null) {
            vegetablesDropdown.expand();
            for (String vegetable : vegetables) {
                for (UIElement elem : vegetablesDropdown.list()) {
                    if (elem.getText().equals(vegetable)) {
                        elem.click();
                        break;
                    }
                }
            }
        }

        if (submitButton != null) {
            submitButton.click();
        }
    }

    private void selectInDropdown(Dropdown dropdown, String dropdownValue) {
        if (dropdown != null) {
            dropdown.expand();
            for (UIElement value : dropdown.list()) {
                if (value.getText().equals(dropdownValue)) {
                    value.click();
                    break;
                }
            }
        }
    }

    @Step("Check log on Metals and Colors page")
    public void checkMetalsAndColorsResults(List<Double> summary, List<String> elements,
                                            String color, String metal, List<String> vegetables) {
        if (summary.size() > 0) {
            int summarySum = 0;
            for (Double elem : summary) {
                summarySum += elem.intValue();
            }
            assertThat(summaryResult.getText(), is("Summary: " + summarySum));
        }

        if (elements.size() > 0) {
            for (String elem : elements) {
                assertThat(elementsResult.getText(), containsString(elem));
            }
            assertThat(elementsResult.getText(), containsString("Elements:"));
        }

        assertThat(colorResult.getText(), is("Color: " + color));
        assertThat(metalResult.getText(), is("Metal: " + metal));

        if (vegetables.size() > 0) {
            for (String elem : vegetables) {
                assertThat(vegetablesResult.getText(), containsString(elem));
            }
            assertThat(vegetablesResult.getText(), containsString("Vegetables:"));
        }
    }
}

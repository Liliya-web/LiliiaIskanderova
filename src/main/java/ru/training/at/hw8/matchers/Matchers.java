package ru.training.at.hw8.matchers;

import ru.training.at.hw8.beans.TrelloResponse;
import ru.training.at.hw8.constants.PermissionLevel;
import ru.training.at.hw8.constants.ResponseField;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class Matchers {
    public static void assertJsonValue(TrelloResponse response, ResponseField responseField, String value) {
        assertThat("'" + responseField + "' field have not proper value '" + responseField.name
                        + "'. Value should be '" + value + " '",
                response, hasProperty(responseField.name, is(value)));
    }

    public static void assertJsonPermissionValue(TrelloResponse response,
                                       ResponseField insertedField, PermissionLevel value) {
        assertThat("'" + insertedField + "' field have not proper value '"
                        + insertedField.name + "'. Value should be '" + value.permissionLevel + " '",
                response.getPrefs(), hasProperty(insertedField.name, is(value.permissionLevel)));
    }

    public static void assertJsonLabelValue(TrelloResponse response, ResponseField insertedField, String value) {
        assertThat("'" + insertedField + "' field have not proper value '"
                        + insertedField.name + "'. Value should be '" + value + " '",
                response.getLabelNames(), hasProperty(insertedField.name, is(value)));
    }
}

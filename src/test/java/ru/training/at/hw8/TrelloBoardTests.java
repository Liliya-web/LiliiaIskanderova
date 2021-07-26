package ru.training.at.hw8;

import static ru.training.at.hw8.constants.ResponseField.DESC;
import static ru.training.at.hw8.constants.ResponseField.ID;
import static ru.training.at.hw8.constants.ResponseField.NAME;
import static ru.training.at.hw8.constants.ResponseField.PERMISSION;
import static ru.training.at.hw8.constants.ResponseField.PURPLE;
import static ru.training.at.hw8.core.TrelloServiceObject.getAnswer;
import static ru.training.at.hw8.core.TrelloServiceObject.getIdFromResult;
import static ru.training.at.hw8.core.TrelloServiceObject.goodResponseSpecification;
import static ru.training.at.hw8.core.TrelloServiceObject.notFoundResponseSpecification;
import static ru.training.at.hw8.core.TrelloServiceObject.requestBuilder;
import static ru.training.at.hw8.matchers.Matchers.assertJsonLabelValue;
import static ru.training.at.hw8.matchers.Matchers.assertJsonPermissionValue;
import static ru.training.at.hw8.matchers.Matchers.assertJsonValue;

import io.restassured.http.Method;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.training.at.hw8.beans.TrelloResponse;
import ru.training.at.hw8.constants.PermissionLevel;
import ru.training.at.hw8.core.DataProviderForTrello;

public class TrelloBoardTests {

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestContext context) {
        requestBuilder()
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequest(context.getCurrentXmlTest().getParameter("id"));
    }

    @Test(dataProvider = "defaultBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void createDefaultBoardTest(ITestContext context, String boardName, PermissionLevel permissionPrivate) {
        TrelloResponse response = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(boardName)
                        .buildRequest()
                        .sendRequest());
        context.getCurrentXmlTest().addParameter("id", getIdFromResult(response));
        assertJsonValue(response, NAME, boardName);
        assertJsonPermissionValue(response, PERMISSION, permissionPrivate);
    }

    @Test(dataProvider = "orgBoardWithDescriptionDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void createBoardWithCustomParametersTest(ITestContext context, String boardName, String description, PermissionLevel permissionOrg) {
        TrelloResponse response = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(boardName)
                        .setDescription(description)
                        .setPermissionLevelCreate(permissionOrg)
                        .buildRequest()
                        .sendRequest());
        context.getCurrentXmlTest().addParameter("id", getIdFromResult(response));
        assertJsonValue(response, NAME, boardName);
        assertJsonValue(response, DESC, description);
        assertJsonPermissionValue(response, PERMISSION, permissionOrg);
    }

    @Test(dataProvider = "publicBoardWithTwoNamesDescriptionLabelNameDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void updateDefaultBoardTest(ITestContext context, String defaultBoardName, String newBoardName, String description,
                                       PermissionLevel permissionPublic, String labelName) throws InterruptedException {
        TrelloResponse responsePost = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(defaultBoardName)
                        .buildRequest()
                        .sendRequest());
        String id = getIdFromResult(responsePost);
        context.getCurrentXmlTest().addParameter("id", id);
        assertJsonValue(responsePost, NAME, defaultBoardName);

        TrelloResponse responsePut = getAnswer(
                requestBuilder()
                        .setMethod(Method.PUT)
                        .setName(newBoardName)
                        .setDescription(description)
                        .setPermissionLevel(permissionPublic)
                        .setPurpleLabelName(labelName)
                        .buildRequest()
                        .sendRequest(id));
        assertJsonValue(responsePut, NAME, newBoardName);
        assertJsonValue(responsePut, DESC, description);
        assertJsonPermissionValue(responsePut, PERMISSION, permissionPublic);
        assertJsonLabelValue(responsePut, PURPLE, labelName);
    }

    @Test(dataProvider = "publicBoardWithTwoNamesTwoDescriptionsLabelNameDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void updateBoardWithCustomParametersTest(ITestContext context, String defaultBoardName, String newBoardName,
                                                    String description, String newDescription,
                                                    PermissionLevel permissionPublic, String labelName) {
        TrelloResponse responsePost = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(defaultBoardName)
                        .setDescription(description)
                        .setPermissionLevelCreate(permissionPublic)
                        .buildRequest()
                        .sendRequest());
        String id = getIdFromResult(responsePost);
        context.getCurrentXmlTest().addParameter("id", id);
        assertJsonValue(responsePost, NAME, defaultBoardName);
        assertJsonValue(responsePost, DESC, description);
        assertJsonPermissionValue(responsePost, PERMISSION, permissionPublic);

        TrelloResponse responsePut = getAnswer(
                requestBuilder()
                        .setMethod(Method.PUT)
                        .setName(newBoardName)
                        .setDescription(newDescription)
                        .setPermissionLevel(permissionPublic)
                        .setPurpleLabelName(labelName)
                        .buildRequest()
                        .sendRequest(id));
        assertJsonValue(responsePut, NAME, newBoardName);
        assertJsonValue(responsePut, DESC, newDescription);
        assertJsonPermissionValue(responsePut, PERMISSION, permissionPublic);
        assertJsonLabelValue(responsePut, PURPLE, labelName);
    }

    @Test(dataProvider = "boardsWithDifferentPermissionsDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void getBoardsWithDifferentPermissionsTest(ITestContext context, String boardName,
                                                      PermissionLevel permissionLevel) {
        TrelloResponse responsePost = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(boardName)
                        .setPermissionLevelCreate(permissionLevel)
                        .buildRequest()
                        .sendRequest());
        String id = getIdFromResult(responsePost);
        context.getCurrentXmlTest().addParameter("id", id);
        assertJsonValue(responsePost, NAME, boardName);
        assertJsonPermissionValue(responsePost, PERMISSION, permissionLevel);

        TrelloResponse responseGet = getAnswer(
                requestBuilder()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendRequest(id));
        assertJsonValue(responseGet, ID, id);
        assertJsonValue(responseGet, NAME, boardName);
        assertJsonPermissionValue(responseGet, PERMISSION, permissionLevel);
    }

    @Test(dataProvider = "boardsWithDifferentPermissionsDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void deleteBoardsWithDifferentPermissionsTest(ITestContext context, String boardName, PermissionLevel permissionLevel) {
        TrelloResponse response = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(boardName)
                        .setPermissionLevelCreate(permissionLevel)
                        .buildRequest()
                        .sendRequest());
        String id = getIdFromResult(response);
        context.getCurrentXmlTest().addParameter("id", id);
        assertJsonValue(response, NAME, boardName);
        assertJsonPermissionValue(response, PERMISSION, permissionLevel);

        requestBuilder()
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequest(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());

        requestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(id)
                .then()
                .assertThat()
                .spec(notFoundResponseSpecification());
    }
}

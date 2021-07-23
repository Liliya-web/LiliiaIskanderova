package ru.training.at.hw8;

import static ru.training.at.hw8.constants.ResponseField.*;
import static ru.training.at.hw8.core.TrelloServiceObject.*;
import static ru.training.at.hw8.matchers.Matchers.*;


import io.restassured.http.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.training.at.hw8.beans.TrelloResponse;
import ru.training.at.hw8.constants.PermissionLevel;
import ru.training.at.hw8.core.DataProviderForTrello;

public class TrelloBoardTests {
    @Test(dataProvider = "createDefaultBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void createDefaultBoardTest(String boardName, PermissionLevel permissionPrivate) {
        TrelloResponse response = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(boardName)
                        .buildRequest()
                        .sendRequest());
        assertJsonValue(response, NAME, boardName);
        assertJsonPermissionValue(response, PERMISSION, permissionPrivate);

        deleteBoard(getIdFromResult(response));
    }

    @Test(dataProvider = "createBoardWithCustomParametersDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void createBoardWithCustomParametersTest(String boardName, String description, PermissionLevel permissionOrg) {
        TrelloResponse response = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(boardName)
                        .setDescription(description)
                        .setPermissionLevelCreate(permissionOrg)
                        .buildRequest()
                        .sendRequest());
        assertJsonValue(response, NAME, boardName);
        assertJsonValue(response, DESC, description);
        assertJsonPermissionValue(response, PERMISSION, permissionOrg);

        deleteBoard(getIdFromResult(response));
    }

    @Test(dataProvider = "updateBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void updateDefaultBoardTest(String defaultBoardName, String newBoardName, String description,
                                       PermissionLevel permissionPublic, String labelName) throws InterruptedException {
        TrelloResponse responsePost = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(defaultBoardName)
                        .buildRequest()
                        .sendRequest());
        assertJsonValue(responsePost, NAME, defaultBoardName);

        String id = getIdFromResult(responsePost);

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

        deleteBoard(id);
    }

    @Test(dataProvider = "updateBoardWithCustomParametersDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void updateBoardWithCustomParametersTest(String defaultBoardName, String newBoardName, String description,
                                                    String newDescription, PermissionLevel permissionPublic, String labelName) {
        TrelloResponse responsePost = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(defaultBoardName)
                        .setDescription(description)
                        .setPermissionLevelCreate(permissionPublic)
                        .buildRequest()
                        .sendRequest());
        assertJsonValue(responsePost, NAME, defaultBoardName);
        assertJsonValue(responsePost, DESC, description);
        assertJsonPermissionValue(responsePost, PERMISSION, permissionPublic);

        String id = getIdFromResult(responsePost);

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

        deleteBoard(id);
    }

    @Test(dataProvider = "createBoardsWithDifferentPermissionsDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void getBoardsWithDifferentPermissionsTest(String boardName, PermissionLevel permissionLevel) {
        TrelloResponse responsePost = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(boardName)
                        .setPermissionLevelCreate(permissionLevel)
                        .buildRequest()
                        .sendRequest());
        assertJsonValue(responsePost, NAME, boardName);
        assertJsonPermissionValue(responsePost, PERMISSION, permissionLevel);

        String id = getIdFromResult(responsePost);

        TrelloResponse responseGet = getAnswer(
                requestBuilder()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendRequest(id));
        assertJsonValue(responseGet, ID, id);
        assertJsonValue(responseGet, NAME, boardName);
        assertJsonPermissionValue(responseGet, PERMISSION, permissionLevel);

        deleteBoard(id);
    }

    @Test(dataProvider = "createBoardsWithDifferentPermissionsDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void deleteBoardsWithDifferentPermissionsTest(String boardName, PermissionLevel permissionLevel) {
        TrelloResponse response = getAnswer(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setName(boardName)
                        .setPermissionLevelCreate(permissionLevel)
                        .buildRequest()
                        .sendRequest());
        assertJsonValue(response, NAME, boardName);
        assertJsonPermissionValue(response, PERMISSION, permissionLevel);

        String id = getIdFromResult(response);

        deleteBoard(id);

        requestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(id)
                .then()
                .assertThat()
                .spec(notFoundResponseSpecification());
    }

    private void deleteBoard(String id) {
        requestBuilder()
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequest(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());
    }
}

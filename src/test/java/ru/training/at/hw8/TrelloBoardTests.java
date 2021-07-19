package ru.training.at.hw8;

import static org.hamcrest.Matchers.equalTo;
import static ru.training.at.hw8.constants.ParameterName.BOARD_NAME;
import static ru.training.at.hw8.constants.ParameterName.DESCRIPTION;
import static ru.training.at.hw8.constants.ParameterName.PERMISSION_LEVEL;
import static ru.training.at.hw8.constants.ParameterName.PERMISSION_LEVEL_CREATE;
import static ru.training.at.hw8.constants.ParameterName.PURPLE_LABEL_NAME;
import static ru.training.at.hw8.constants.ResponseField.DESC;
import static ru.training.at.hw8.constants.ResponseField.ID;
import static ru.training.at.hw8.constants.ResponseField.LABEL_NAMES;
import static ru.training.at.hw8.constants.ResponseField.NAME;
import static ru.training.at.hw8.constants.ResponseField.PERMISSION;
import static ru.training.at.hw8.core.TrelloServiceObject.goodResponseSpecification;
import static ru.training.at.hw8.core.TrelloServiceObject.notFoundResponseSpecification;
import static ru.training.at.hw8.core.TrelloServiceObject.requestSpecification;

import io.restassured.RestAssured;
import java.util.LinkedHashMap;
import java.util.Map;
import org.testng.annotations.Test;
import ru.training.at.hw8.constants.PermissionLevel;
import ru.training.at.hw8.core.DataProviderForTrello;

public class TrelloBoardTests {
    @Test(dataProvider = "createDefaultBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void createDefaultBoardTest(String boardName, PermissionLevel permissionPrivate) {
        String id = RestAssured
                .given(requestSpecification()).log().all()
                .queryParam(BOARD_NAME, boardName)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(boardName))
                .body(PERMISSION.name, equalTo(permissionPrivate.permissionLevel))
                .extract()
                .path(ID.name);

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .delete(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());
    }

    @Test(dataProvider = "createBoardWithCustomParametersDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void createBoardWithCustomParametersTest(String boardName, String description, PermissionLevel permissionOrg) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put(BOARD_NAME, boardName);
        parameters.put(DESCRIPTION, description);
        parameters.put(PERMISSION_LEVEL_CREATE, permissionOrg.permissionLevel);

        String id = RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(boardName))
                .body(DESC.name, equalTo(description))
                .body(PERMISSION.name, equalTo(permissionOrg.permissionLevel))
                .extract()
                .path(ID.name);

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .delete(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());
    }

    @Test(dataProvider = "updateBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void updateDefaultBoardTest(String defaultBoardName, String newBoardName, String description,
                                       PermissionLevel permissionPublic, String labelName) throws InterruptedException {
        String id = RestAssured
                .given(requestSpecification()).log().all()
                .queryParam(BOARD_NAME, defaultBoardName)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(defaultBoardName))
                .extract()
                .path(ID.name);

        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put(BOARD_NAME, newBoardName);
        parameters.put(DESCRIPTION, description);
        parameters.put(PERMISSION_LEVEL, permissionPublic.permissionLevel);
        parameters.put(PURPLE_LABEL_NAME, labelName);

        RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .when()
                .put(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(newBoardName))
                .body(DESC.name, equalTo(description))
                .body(PERMISSION.name, equalTo(permissionPublic.permissionLevel))
                .body(LABEL_NAMES.name, equalTo(labelName));

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .delete(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());
    }

    @Test(dataProvider = "updateBoardWithCustomParametersDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void updateBoardWithCustomParametersTest(String defaultBoardName, String newBoardName, String description,
                                                    String newDescription, PermissionLevel permissionPublic, String labelName) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put(BOARD_NAME, defaultBoardName);
        parameters.put(DESCRIPTION, description);
        parameters.put(PERMISSION_LEVEL_CREATE, permissionPublic.permissionLevel);

        String id = RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(defaultBoardName))
                .body(DESC.name, equalTo(description))
                .body(PERMISSION.name, equalTo(permissionPublic.permissionLevel))
                .extract()
                .path(ID.name);

        Map<String, String> newParameters = new LinkedHashMap<>();
        newParameters.put(BOARD_NAME, newBoardName);
        newParameters.put(DESCRIPTION, newDescription);
        newParameters.put(PURPLE_LABEL_NAME, labelName);

        RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(newParameters)
                .when()
                .put(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(newBoardName))
                .body(DESC.name, equalTo(newDescription))
                .body(PERMISSION.name, equalTo(permissionPublic.permissionLevel))
                .body(LABEL_NAMES.name, equalTo(labelName));

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .delete(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());
    }

    @Test(dataProvider = "createPublicBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void getPublicBoardTest(String boardName, PermissionLevel permissionPublic) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put(BOARD_NAME, boardName);
        parameters.put(PERMISSION_LEVEL_CREATE, permissionPublic.permissionLevel);

        String id = RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(boardName))
                .body(PERMISSION.name, equalTo(permissionPublic.permissionLevel))
                .extract()
                .path(ID.name);

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .get(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(ID.name, equalTo(id))
                .body(NAME.name, equalTo(boardName));

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .delete(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());
    }

    @Test(dataProvider = "createDefaultBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void getPrivateBoardTest(String boardName, PermissionLevel permissionPrivate) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put(BOARD_NAME, boardName);
        parameters.put(PERMISSION_LEVEL, permissionPrivate.permissionLevel);

        String id = RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(boardName))
                .extract()
                .path(ID.name);

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .get(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(ID.name, equalTo(id))
                .body(NAME.name, equalTo(boardName));

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .delete(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());
    }

    @Test(dataProvider = "createOrgBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void getOrgBoardTest(String boardName, PermissionLevel permissionOrg) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put(BOARD_NAME, boardName);
        parameters.put(PERMISSION_LEVEL_CREATE, permissionOrg.permissionLevel);

        String id = RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(boardName))
                .extract()
                .path(ID.name);

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .get(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(ID.name, equalTo(id))
                .body(NAME.name, equalTo(boardName))
                .body(PERMISSION.name, equalTo(permissionOrg.permissionLevel));

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .delete(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());
    }

    @Test(dataProvider = "createDefaultBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void deletePrivateBoardTest(String boardName, PermissionLevel permissionPrivate) {
        String id = RestAssured
                .given(requestSpecification()).log().all()
                .queryParam(BOARD_NAME, boardName)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(boardName))
                .body(PERMISSION.name, equalTo(permissionPrivate.permissionLevel))
                .extract()
                .path(ID.name);

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .delete(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .get(id)
                .then()
                .assertThat()
                .spec(notFoundResponseSpecification());
    }

    @Test(dataProvider = "createPublicBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void deletePublicBoardTest(String boardName, PermissionLevel permissionPublic) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put(BOARD_NAME, boardName);
        parameters.put(PERMISSION_LEVEL_CREATE, permissionPublic.permissionLevel);

        String id = RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(boardName))
                .body(PERMISSION.name, equalTo(permissionPublic.permissionLevel))
                .extract()
                .path(ID.name);

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .delete(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .get(id)
                .then()
                .assertThat()
                .spec(notFoundResponseSpecification());
    }

    @Test(dataProvider = "createOrgBoardDataProvider",
            dataProviderClass = DataProviderForTrello.class)
    public void deleteOrgBoardTest(String boardName, PermissionLevel permissionOrg) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put(BOARD_NAME, boardName);
        parameters.put(PERMISSION_LEVEL_CREATE, permissionOrg.permissionLevel);

        String id = RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .when()
                .post()
                .then()
                .assertThat()
                .spec(goodResponseSpecification())
                .body(NAME.name, equalTo(boardName))
                .body(PERMISSION.name, equalTo(permissionOrg.permissionLevel))
                .extract()
                .path(ID.name);

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .delete(id)
                .then()
                .assertThat()
                .spec(goodResponseSpecification());

        RestAssured
                .given(requestSpecification()).log().all()
                .when()
                .get(id)
                .then()
                .assertThat()
                .spec(notFoundResponseSpecification());
    }
}

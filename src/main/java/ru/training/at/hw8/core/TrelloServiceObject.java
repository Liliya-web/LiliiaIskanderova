package ru.training.at.hw8.core;

import static org.hamcrest.Matchers.lessThan;
import static ru.training.at.hw8.constants.ParameterName.API_KEY;
import static ru.training.at.hw8.constants.ParameterName.API_TOKEN;
import static ru.training.at.hw8.constants.ParameterName.BOARD_NAME;
import static ru.training.at.hw8.constants.ParameterName.DESCRIPTION;
import static ru.training.at.hw8.constants.ParameterName.PERMISSION_LEVEL;
import static ru.training.at.hw8.constants.ParameterName.PERMISSION_LEVEL_CREATE;
import static ru.training.at.hw8.constants.ParameterName.PURPLE_LABEL_NAME;
import static ru.training.at.hw8.constants.SingleValueParameter.KEY;
import static ru.training.at.hw8.constants.SingleValueParameter.TOKEN;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.net.URI;
import java.util.*;

import org.apache.http.HttpStatus;
import ru.training.at.hw8.beans.TrelloResponse;
import ru.training.at.hw8.constants.PermissionLevel;

public class TrelloServiceObject {
    public static final String STRING_TRELLO_URI_FOR_BOARD = "https://trello.com/1/boards/";
    public static final URI TRELLO_URI_FOR_BOARD = URI.create(STRING_TRELLO_URI_FOR_BOARD);

    private final Method requestMethod;
    private final Map<String, String> parameters;

    private TrelloServiceObject(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setName(String boardName) {
            parameters.put(BOARD_NAME, boardName);
            return this;
        }

        public ApiRequestBuilder setDescription(String description) {
            parameters.put(DESCRIPTION, description);
            return this;
        }

        public ApiRequestBuilder setPermissionLevel(PermissionLevel permissionLevel) {
            parameters.put(PERMISSION_LEVEL, permissionLevel.permissionLevel);
            return this;
        }

        public ApiRequestBuilder setPermissionLevelCreate(PermissionLevel permissionLevel) {
            parameters.put(PERMISSION_LEVEL_CREATE, permissionLevel.permissionLevel);
            return this;
        }

        public ApiRequestBuilder setPurpleLabelName(String labelName) {
            parameters.put(PURPLE_LABEL_NAME, labelName);
            return this;
        }

        public TrelloServiceObject buildRequest() {
            return new TrelloServiceObject(parameters, requestMethod);
        }
    }

    public Response sendRequest() {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(requestMethod, TRELLO_URI_FOR_BOARD)
                .prettyPeek();
    }

    public Response sendRequest(String id) {
        return RestAssured
                .given(requestSpecification(id)).log().all()
                .queryParams(parameters)
                .request(requestMethod, URI.create(STRING_TRELLO_URI_FOR_BOARD + id))
                .prettyPeek();
    }

    public static TrelloResponse getAnswer(Response response) {
        return new Gson()
                .fromJson(response.asString().trim(), new TypeToken<TrelloResponse>() {
                }.getType());
    }

    public static String getIdFromResult(TrelloResponse response) {
        return response.getId();
    }

    public static RequestSpecification requestSpecification() {
        Map<String, String> compulsoryParams = new LinkedHashMap<>();
        compulsoryParams.put(API_KEY, KEY);
        compulsoryParams.put(API_TOKEN, TOKEN);
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addQueryParams(compulsoryParams)
                .build();
    }

    public static RequestSpecification requestSpecification(String id) {
        Map<String, String> compulsoryParams = new LinkedHashMap<>();
        compulsoryParams.put(API_KEY, KEY);
        compulsoryParams.put(API_TOKEN, TOKEN);
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addQueryParams(compulsoryParams)
                .setBaseUri(URI.create(STRING_TRELLO_URI_FOR_BOARD + id))
                .setBasePath(id)
                .build();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(6000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification notFoundResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.TEXT)
                .expectResponseTime(lessThan(6000L))
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }
}

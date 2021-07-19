package ru.training.at.hw8.core;

import static org.hamcrest.Matchers.lessThan;
import static ru.training.at.hw8.constants.ParameterName.API_KEY;
import static ru.training.at.hw8.constants.ParameterName.API_TOKEN;
import static ru.training.at.hw8.constants.SingleValueParameter.KEY;
import static ru.training.at.hw8.constants.SingleValueParameter.TOKEN;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.HttpStatus;

public class TrelloServiceObject {
    public static final URI TRELLO_URI = URI.create("https://trello.com/1/boards/");

    public static RequestSpecification requestSpecification() {
        Map<String, String> compulsoryParams = new LinkedHashMap<>();
        compulsoryParams.put(API_KEY, KEY);
        compulsoryParams.put(API_TOKEN, TOKEN);
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addQueryParams(compulsoryParams)
                .setBaseUri(TRELLO_URI)
                .build();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(4000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification notFoundResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.TEXT)
                .expectResponseTime(lessThan(4000L))
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }
}

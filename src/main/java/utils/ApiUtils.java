package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ApiUtils {

    public static RequestSpecification getRequestSpec() {
        return given()
                .header("x-api-key", Config.API_KEY)
                .header("Content-Type", "application/json");
    }

    public static Response sendGet(String endpoint) {
        return getRequestSpec()
                .when()
                .get(endpoint)
                .then()
                .extract().response();
    }

    public static Response sendPost(String endpoint, String body) {
        return getRequestSpec()
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }

    public static Response sendPut(String endpoint, String body) {
        return getRequestSpec()
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract().response();
    }

    public static Response sendDelete(String endpoint) {
        return getRequestSpec()
                .when()
                .delete(endpoint)
                .then()
                .extract().response();
    }
}

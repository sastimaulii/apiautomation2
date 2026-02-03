package requests;

import io.restassured.response.Response;
import utils.ApiUtils;
import utils.Config;

public class UserApiRequests {

    public static Response getUsers() {
        return ApiUtils.sendGet(Config.BASE_URL);
    }

    public static Response createUser(String name, String job) {
        String body = String.format("{\"name\":\"%s\", \"job\":\"%s\"}", name, job);
        return ApiUtils.sendPost("https://reqres.in/api/users", body);
    }

    public static Response updateUser(String id, String name, String job) {
        String body = String.format("{\"name\":\"%s\", \"job\":\"%s\"}", name, job);
        return ApiUtils.sendPut("https://reqres.in/api/users/" + id, body);
    }

    public static Response deleteUser(String id) {
        return ApiUtils.sendDelete("https://reqres.in/api/users/" + id);
    }
}

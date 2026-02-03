package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import requests.UserApiRequests;

public class UserApiTests {

    @Test(description = "Positive Test - Get Users")
    public void testGetUsers() {
        Response response = UserApiRequests.getUsers();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0, "User list should not be empty");
    }

    @Test(description = "Positive Test - Create User")
    public void testCreateUser() {
        Response response = UserApiRequests.createUser("John Doe", "Developer");
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), "John Doe");
    }

    @Test(description = "Negative Test - Create User with Empty Name")
    public void testCreateUserEmptyName() {
        Response response = UserApiRequests.createUser("", "Developer");
        Assert.assertEquals(response.getStatusCode(), 201); // Reqres API masih akan mengembalikan 201
    }

    @Test(description = "Boundary Test - Create User with Long Name")
    public void testCreateUserLongName() {
        String longName = "A".repeat(300);
        Response response = UserApiRequests.createUser(longName, "Developer");
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), longName);
    }
}

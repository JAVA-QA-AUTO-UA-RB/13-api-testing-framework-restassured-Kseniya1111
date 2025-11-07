package org.example.helpers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserApiHelper {
    private static final String USERS = "/users";
    private final RequestSpecification requestSpec;

    public UserApiHelper(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public Response getUserById(int id) {
        return requestSpec.when().get(USERS + "/" + id);
    }

    public Response getUserByUsername(String username) {
        return requestSpec.when().get(USERS + "?username=" + username);
    }
}

package org.example.helpers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommentApiHelper {
    private static final String COMMENTS = "/comments";
    private final RequestSpecification requestSpec;

    public CommentApiHelper(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public Response getCommentById(int id) {
        return requestSpec.when().get(COMMENTS + "/" + id);
    }

    public Response getCommentsByPostId(int postId) {
        return requestSpec.when().get(COMMENTS + "?postId=" + postId);
    }
}

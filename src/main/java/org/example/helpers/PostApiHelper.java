package org.example.helpers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.models.Post;

public class PostApiHelper {

    private final RequestSpecification requestSpec;
    private static final String POSTS = "/posts";

    public PostApiHelper(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public Response getPostById(int id) {
        return requestSpec
                .when()
                .get(POSTS + "/" + id);
    }

    public Response createPost(Post post) {
        return requestSpec
                .body(post)
                .when()
                .post(POSTS);
    }

    public Response updatePost(int id, Post post) {
        return requestSpec
                .body(post)
                .when()
                .put(POSTS + "/" + id);
    }

    public Response deletePost(int id) {
        return requestSpec
                .when()
                .delete(POSTS + "/" + id);
    }
}

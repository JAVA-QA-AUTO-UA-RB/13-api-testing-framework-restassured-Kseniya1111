package org.example.tests;


import org.example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.helpers.PostApiHelper;
import org.example.models.Post;
import io.restassured.response.Response;

public class PlaceholderAPIPostsTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void testGetPost() {
        PostApiHelper helper = new PostApiHelper(requestSpec);

        Response response = helper.getPostById(1);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
        Assert.assertNotNull(response.jsonPath().getString("title"), "Title should not be null");
    }

    @Test(groups = "regression")
    public void testCreatePost() {
        PostApiHelper helper = new PostApiHelper(requestSpec);
        Post post = new Post(1, 0, "New Title", "New Body");

        Response response = helper.createPost(post);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("title"), "New Title");
    }

    @Test(groups = "regression")
    public void testUpdatePost() {
        PostApiHelper helper = new PostApiHelper(requestSpec);
        Post updatedPost = new Post(1, 1, "Updated Title", "Updated Body");

        Response response = helper.updatePost(1, updatedPost);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "Updated Title");
    }

    @Test(groups = "regression")
    public void testDeletePost() {
        PostApiHelper helper = new PostApiHelper(requestSpec);
        Response response = helper.deletePost(1);

        Assert.assertEquals(response.statusCode(), 200);
    }
}

package api;

import io.restassured.response.Response;
import model.Post.PostVO;
import model.Post.PostVORequest;

import static io.restassured.RestAssured.given;
import static utils.SpecFactory.*;

public class PostsAPIImpl {
    public Response getUserById(int id) {
        return given()
                .spec(requestSpec())
                .pathParam("id", id)
                .when()
                .get("/users/{id}");
    }

    public Response getAllPosts() {
        return given()
                .spec(requestSpec())
                .when()
                .get("/posts");
    }

    public Response getCommentsByPostId(int postId) {
        return given()
                .spec(requestSpec())
                .pathParam("postId", postId)
                .when()
                .get("comments?postId={postId}");
    }

    public Response postNewPost(PostVORequest body) {
        return given()
                .spec(requestSpec())
                .body(body)
                .when()
                .post("/posts");
    }

    public Response updatePostById(int postId, PostVORequest body) {
        return given()
                .spec(requestSpec())
                .pathParam("postId", postId)
                .body(body)
                .when()
                .put("/posts/{postId}");
    }

}

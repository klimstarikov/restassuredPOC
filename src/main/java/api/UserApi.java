package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static utils.SpecFactory.*;

public class UserApi {
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

}

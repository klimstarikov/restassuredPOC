package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static utils.SpecFactory.requestSpec;

public class CommentsAPIImpl {
    public Response getCommentsToPostByPath(int postId) {
        return given()
                .spec(requestSpec())
                .pathParam("postId", postId)
                .when()
                .get("/posts/{postId}/comments");
    }

    public Response deleteCommentById(int commentId) {
        return given()
                .spec(requestSpec())
                .pathParam("commentId", commentId)
                .when()
                .delete("/comments/{commentId}");
    }

    public Response getCommentsByPostId(int postId) {
        return given()
                .spec(requestSpec())
                .pathParam("postId", postId)
                .when()
                .get("comments?postId={postId}");
    }

    public Response getCommentsToPostByPathWithExtraQuery(int postId, String id) {
        return given()
                .spec(requestSpec())
                .pathParam("postId", postId)
                .queryParam("id", id)
                .when()
                .get("/posts/{postId}/comments");
    }
}

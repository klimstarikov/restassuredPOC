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
}

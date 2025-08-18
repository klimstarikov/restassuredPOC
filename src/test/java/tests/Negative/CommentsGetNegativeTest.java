package tests.Negative;

import facade.CommentsAPIFacade;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class CommentsGetNegativeTest {
    private CommentsAPIFacade commentsAPIFacade = new CommentsAPIFacade();

    @Test(description = "Get comments by post ID with invalid ID")
    public void getCommentsByPostWithInvalidId() {
        int invalidPostId = 999;
        commentsAPIFacade.getCommentsToPostByPath(invalidPostId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(equalTo("[]")); // Assuming the API returns an empty array for not found
    }

    @Test(description = "Get comments by post ID with extra parameters")
    public void getCommentsByPostWithExtraParameters() {
        int postId = 1;
        String extraParamId = "9";
        commentsAPIFacade.getCommentsToPostByPathWithExtraQuery(postId, extraParamId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(equalTo("[]"));
    }
}
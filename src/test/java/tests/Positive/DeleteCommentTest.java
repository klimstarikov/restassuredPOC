package tests.Positive;

import facade.APIFacade;
import facade.CommentsAPIFacade;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isOneOf;

@Epic("Comment API Tests")
@Feature("Delete Comment Feature")
public class DeleteCommentTest extends BaseTest {
    CommentsAPIFacade commentsAPIFacade = new CommentsAPIFacade();


    @Test(description = "Delete comment by ID and verify response")
    @Story("Delete Comment Story")
    @Parameters({"commentId"})
    public void deleteCommentTest(int commentId) {
        commentsAPIFacade.deleteCommentById(commentId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(equalTo("{}"));
    }
}

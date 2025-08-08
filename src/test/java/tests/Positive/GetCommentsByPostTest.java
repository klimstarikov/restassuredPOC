package tests.Positive;

import facade.UserFacade;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.CommentVO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

@Epic("User API Tests")
@Feature("Get Comments by Post Feature")
public class GetCommentsByPostTest extends BaseTest {
    private UserFacade userFacade = new UserFacade();

    @Test(description = "Get comments by post ID")
    @Parameters({"postId", "expectedNumberOfComments"})
    @Story("Get Comments by Post Story")
    public void getCommentsByPost(int postId, int expectedNumberOfComments) {
        int actualNumberOfComments;
        List<CommentVO> retrievedComments = userFacade.getCommentsByPostId(postId);
        assert (retrievedComments != null && !retrievedComments.isEmpty()) : "Retrieved comments should not be null or empty";
        actualNumberOfComments = retrievedComments.stream().filter(i -> i.getPostId() == postId).toList().size();
        assert actualNumberOfComments == expectedNumberOfComments : "Expected number of comments does not match actual number of comments for post ID " + postId;
    }

    @Test(description = "Get comments by post ID using path")
    @Parameters({"postId", "expectedNumberOfComments"})
    @Story("Get Comments by Post Path Story")
    public void getCommentsByPostPath(int postId, int expectedNumberOfComments) {
        int actualNumberOfComments;
        List<CommentVO> retrievedComments = userFacade.getCommentsToPostByPath(postId);
        assert (retrievedComments != null && !retrievedComments.isEmpty()) : "Retrieved comments should not be null or empty";
        actualNumberOfComments = retrievedComments.stream().filter(i -> i.getPostId() == postId).toList().size();
        assert actualNumberOfComments == expectedNumberOfComments : "Expected number of comments does not match actual number of comments for path ID " + postId;
    }
}

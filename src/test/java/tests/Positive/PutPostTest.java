package tests.Positive;

import facade.UserFacade;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.Post.PostVOBuilder;
import model.Post.PostVO;
import model.Post.PostVORequest;
import model.Post.PostVORequestFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

@Epic("User API Tests")
@Feature("Update Post Feature")
public class PutPostTest extends BaseTest {
    private UserFacade userFacade = new UserFacade();

    @Test(description = "Update post with random fileds and verify response")
    @Parameters({"postId"})
    @Story("Update Post Story")
    public void putRandomPost(int postId) {
        PostVORequest body = PostVORequestFactory.randomPostVORequest();
        PostVO actualResponse = userFacade.updatePostById(postId, body)
                .then()
                .statusCode(200)
                .extract()
                .as(PostVO.class);

        PostVO expectedResponse = new PostVOBuilder()
                .withId(actualResponse.getId())
                .withBody(body.getBody())
                .withTitle(body.getTitle())
                .withUserId(body.getUserId())
                .build();

        Assert.assertEquals(expectedResponse, actualResponse, "Expected response does not match actual response");
    }
}

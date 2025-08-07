package tests.Positive;

import facade.UserFacade;
import model.Post.PostVOBuilder;
import model.Post.PostVO;
import model.Post.PostVORequest;
import model.Post.PostVORequestFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PutPostTest {
    private UserFacade userFacade = new UserFacade();

    @Test(description = "Update post with random fileds and verify response")
    @Parameters({"postId"})
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

package tests.Positive;

import facade.UserFacade;
import model.Post.PostBuilder;
import model.Post.PostVO;
import model.Post.PostVORequest;
import model.Post.PostVORequestFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostPostTest {
    private UserFacade userFacade = new UserFacade();

    @Test(description = "POST random Post request and verify response")
    public void postRandomPost() {
        PostVORequest requestBody = PostVORequestFactory.randomPostVORequest();
        PostVO actualResponse = userFacade.postNewPost(requestBody)
                .then()
                .statusCode(201)
                .extract()
                .as(PostVO.class);

        PostVO expectedResponse = new PostBuilder()
                .withId(actualResponse.getId())
                .withBody(requestBody.getBody())
                .withTitle(requestBody.getTitle())
                .withUserId(requestBody.getUserId())
                .build();
        Assert.assertEquals(expectedResponse, actualResponse,
                "Expected response does not match actual response");
    }

}

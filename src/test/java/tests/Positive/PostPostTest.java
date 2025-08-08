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
import org.testng.annotations.Test;
import tests.BaseTest;

@Epic("User API Tests")
@Feature("Post Creation Feature")
public class PostPostTest extends BaseTest {
    private UserFacade userFacade = new UserFacade();

    @Test(description = "POST random Post request and verify response")
    @Story("Post Random Post Story")
    public void postRandomPost() {
        PostVORequest requestBody = PostVORequestFactory.randomPostVORequest();
        PostVO actualResponse = userFacade.postNewPost(requestBody)
                .then()
                .statusCode(201)
                .extract()
                .as(PostVO.class);

        PostVO expectedResponse = new PostVOBuilder()
                .withId(actualResponse.getId())
                .withBody(requestBody.getBody())
                .withTitle(requestBody.getTitle())
                .withUserId(requestBody.getUserId())
                .build();
        Assert.assertEquals(expectedResponse, actualResponse,
                "Expected response does not match actual response");
    }

}

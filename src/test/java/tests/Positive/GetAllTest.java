package tests.Positive;

import api.PostsAPIImpl;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.Post.PostVO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

@Epic("User API Tests")
@Feature("Get All Posts Feature")
public class GetAllTest extends BaseTest {

    @Test(description = "Get all posts")
    @Parameters({"userId", "numberOfPosts"})
    @Story("Get All Posts Story")
    public void getAllPosts(int userId, int numberOfPosts) {
        List<PostVO> postVOS = new PostsAPIImpl().getAllPosts()
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("", PostVO.class);

        List<PostVO> expectedPosts = postVOS.stream()
                .filter(p -> p.getUserId() == userId)
                .toList();
        assert expectedPosts.size() == numberOfPosts : "Expected number of posts does not match actual number of posts";
    }
}

package tests;

import api.UserApi;
import model.PostVO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllTest {

    @Test(description = "Get all posts")
    @Parameters ({"userId", "numberOfPosts"})
    public void getAllPosts(int userId, int numberOfPosts) {
        List<PostVO> postVOS = new UserApi().getAllPosts()
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("", PostVO.class);

        List<PostVO> expectedPosts = postVOS.stream()
                .filter(p-> p.getUserId() == userId)
                .toList();
        assert expectedPosts.size() == numberOfPosts : "Expected number of posts does not match actual number of posts";
    }
}

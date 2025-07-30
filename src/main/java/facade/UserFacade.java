package facade;

import api.UserApi;
import io.restassured.response.ValidatableResponse;
import model.CommentVO;
import model.PostVO;
import model.UserTO;
import org.apache.http.HttpStatus;

import java.util.List;

public class UserFacade {
    private final UserApi userApi;

    public UserFacade() {
        this.userApi = new UserApi();
    }

    public UserTO getUserById(int id) {
        return userApi.getUserById(id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(UserTO.class);
    }

    public ValidatableResponse getUserByIdDefault(int id) {
        return userApi.getUserById(id)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public List<CommentVO> getCommentsByPostId(int postId) {
        return userApi.getCommentsByPostId(postId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getList("", CommentVO.class);
    }


}
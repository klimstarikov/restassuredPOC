package facade;

import api.CommentsAPIImpl;
import api.PostsAPIImpl;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import model.CommentVO;
import model.Post.PostVO;
import model.Post.PostVORequest;
import model.User.UserTO;
import org.apache.http.HttpStatus;

import java.util.List;

public class UserFacade {
    private final PostsAPIImpl postsAPIImpl;
    private final CommentsAPIImpl commentsAPIImpl;

    public UserFacade() {
        this.postsAPIImpl = new PostsAPIImpl();
        this.commentsAPIImpl = new CommentsAPIImpl();
    }

    public UserTO getUserById(int id) {
        return postsAPIImpl.getUserById(id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(UserTO.class);
    }

    public ValidatableResponse getUserByIdDefault(int id) {
        return postsAPIImpl.getUserById(id)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public List<CommentVO> getCommentsByPostId(int postId) {
        return postsAPIImpl.getCommentsByPostId(postId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getList("", CommentVO.class);
    }

    public List<CommentVO> getCommentsToPostByPath(int postId) {
        return commentsAPIImpl.getCommentsToPostByPath(postId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getList("", CommentVO.class);
    }

    public Response postNewPost(PostVORequest body) {
        return postsAPIImpl.postNewPost(body)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();
    }


}
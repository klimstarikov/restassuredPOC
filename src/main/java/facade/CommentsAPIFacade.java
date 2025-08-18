package facade;

import api.CommentsAPIImpl;
import io.restassured.response.Response;
import model.CommentVO;

import java.util.List;

public class CommentsAPIFacade {
    private final CommentsAPIImpl commentsAPIImpl;

    public CommentsAPIFacade() {
        this.commentsAPIImpl = new CommentsAPIImpl();
    }

    public List<CommentVO> getCommentsListToPostByPath(int postId) {
        return commentsAPIImpl.getCommentsToPostByPath(postId)
                .then()
                .extract()
                .jsonPath()
                .getList("", CommentVO.class);
    }

    public Response getCommentsToPostByPath(int postId) {
        return commentsAPIImpl.getCommentsToPostByPath(postId)
                .then()
                .extract()
                .response();
    }

    public Response deleteCommentById(int commentId) {
        return commentsAPIImpl.deleteCommentById(commentId)
                .then()
                .extract()
                .response();
    }

    public List<CommentVO> getCommentsByPostId(int postId) {
        return commentsAPIImpl.getCommentsByPostId(postId)
                .then()
                .extract()
                .jsonPath()
                .getList("", CommentVO.class);
    }

    public Response getCommentsToPostByPathWithExtraQuery(int postId, String id) {
        return commentsAPIImpl.getCommentsToPostByPathWithExtraQuery(postId, id)
                .then()
                .extract()
                .response();
    }




}

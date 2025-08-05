package model.Post;

public class PostVORequestBuilder {
    private int userId;
    private String title;
    private String body;

    public PostVORequestBuilder withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public PostVORequestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public PostVORequestBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public PostVORequest build() {
        return new PostVORequest(title, body, userId);
    }
}

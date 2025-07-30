package model;

public class PostBuilder {

    private int userId;
    private int id;
    private String title;
    private String body;

    public PostBuilder withUserId(int userId) {
        this.userId = userId;
        return this;
    }
    public PostBuilder withId(int id) {
        this.id = id;
        return this;
    }
    public PostBuilder withTitle(String title) {
        this.title = title;
        return this;
    }
    public PostBuilder withBody(String body) {
        this.body = body;
        return this;
    }
    public PostVO build() {
        return new PostVO(userId, id, title, body);
    }

}

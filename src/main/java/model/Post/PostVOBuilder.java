package model.Post;

public class PostVOBuilder {

    private int userId;
    private int id;
    private String title;
    private String body;

    public PostVOBuilder withUserId(int userId) {
        this.userId = userId;
        return this;
    }
    public PostVOBuilder withId(int id) {
        this.id = id;
        return this;
    }
    public PostVOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }
    public PostVOBuilder withBody(String body) {
        this.body = body;
        return this;
    }
    public PostVO build() {
        return new PostVO(userId, id, title, body);
    }

}

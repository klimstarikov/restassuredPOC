package model.Album;

public class AlbumVOBuilder {

    private int userId;
    private int id;
    private String title;
    private String body;

    public AlbumVOBuilder withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public AlbumVOBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public AlbumVOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public AlbumVOBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public AlbumVO build() {
        return new AlbumVO(userId, id, title, body);
    }
}

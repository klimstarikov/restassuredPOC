package model.Photo;

public class PhotoVOBuilder {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
    private String body;

    public PhotoVOBuilder withAlbumId(int albumId) {
        this.albumId = albumId;
        return this;
    }

    public PhotoVOBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public PhotoVOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public PhotoVOBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public PhotoVOBuilder withThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    public PhotoVOBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public PhotoVO build() {
        return new PhotoVO(albumId, id, title, url, thumbnailUrl, body);
    }
}

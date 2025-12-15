package model.Photo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PhotoVORequest {
    private int albumId;
    private String title;
    private String url;
    private String thumbnailUrl;
    private String body;

    @JsonCreator
    public PhotoVORequest(@JsonProperty("albumId") int albumId,
                          @JsonProperty("title") String title,
                          @JsonProperty("url") String url,
                          @JsonProperty("thumbnailUrl") String thumbnailUrl,
                          @JsonProperty("body") String body) {
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.body = body;
    }

    public PhotoVORequest() {
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

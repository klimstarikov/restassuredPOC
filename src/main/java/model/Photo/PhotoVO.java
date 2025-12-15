package model.Photo;

// Harmless comment to force file reindexing

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PhotoVO {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
    private String body;

    @JsonCreator
    public PhotoVO(@JsonProperty("albumId") int albumId,
                   @JsonProperty("id") int id,
                   @JsonProperty("title") String title,
                   @JsonProperty("url") String url,
                   @JsonProperty("thumbnailUrl") String thumbnailUrl,
                   @JsonProperty("body") String body) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.body = body;
    }

    public PhotoVO() {
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PhotoVO photoVO)) return false;
        return getAlbumId() == photoVO.getAlbumId() && getId() == photoVO.getId() && Objects.equals(getTitle(), photoVO.getTitle()) && Objects.equals(getUrl(), photoVO.getUrl()) && Objects.equals(getThumbnailUrl(), photoVO.getThumbnailUrl()) && Objects.equals(getBody(), photoVO.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAlbumId(), getId(), getTitle(), getUrl(), getThumbnailUrl(), getBody());
    }

    @Override
    public String toString() {
        return "PhotoVO{" +
                "albumId=" + albumId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

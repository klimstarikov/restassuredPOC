package model.Album;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AlbumVORequest {
    private int userId;
    private String title;
    private String body;

    @JsonCreator
    public AlbumVORequest(@JsonProperty("userId") int userId,
                          @JsonProperty("title") String title,
                          @JsonProperty("body") String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public AlbumVORequest() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

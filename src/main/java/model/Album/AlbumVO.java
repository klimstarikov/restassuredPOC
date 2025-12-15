package model.Album;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class AlbumVO {
    private final int userId;
    private final int id;
    private final String title;
    private final String body;

    @JsonCreator
    public AlbumVO(@JsonProperty("userId") int userId,
                   @JsonProperty("id") int id,
                   @JsonProperty("title") String title,
                   @JsonProperty("body") String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AlbumVO albumVO)) return false;
        return getUserId() == albumVO.getUserId() && getId() == albumVO.getId() && Objects.equals(getTitle(), albumVO.getTitle()) && Objects.equals(getBody(), albumVO.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getId(), getTitle(), getBody());
    }

    @Override
    public String toString() {
        return "AlbumVO{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

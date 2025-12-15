package model.Todo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TodoVO {
    private final int userId;
    private final int id;
    private final String title;
    private final boolean completed;
    private final String body;

    @JsonCreator
    public TodoVO(@JsonProperty("userId") int userId,
                  @JsonProperty("id") int id,
                  @JsonProperty("title") String title,
                  @JsonProperty("completed") boolean completed,
                  @JsonProperty("body") String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
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

    public boolean isCompleted() {
        return completed;
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TodoVO todoVO)) return false;
        return getUserId() == todoVO.getUserId() && getId() == todoVO.getId() && Objects.equals(getTitle(), todoVO.getTitle()) && isCompleted() == todoVO.isCompleted() && Objects.equals(getBody(), todoVO.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getId(), getTitle(), isCompleted(), getBody());
    }

    @Override
    public String toString() {
        return "TodoVO{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", body='" + body + '\'' +
                '}';
    }
}

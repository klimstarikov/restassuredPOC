package model.Todo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoVORequest {
    private int userId;
    private String title;
    private boolean completed;
    private String body;

    @JsonCreator
    public TodoVORequest(@JsonProperty("userId") int userId,
                         @JsonProperty("title") String title,
                         @JsonProperty("completed") boolean completed,
                         @JsonProperty("body") String body) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
        this.body = body;
    }

    public TodoVORequest() {
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

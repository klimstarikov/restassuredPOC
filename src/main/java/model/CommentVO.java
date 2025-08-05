package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentVO {
    private final int postId;
    private final int id;
    private final String name;
    private final String email;
    private final String body;

    @JsonCreator
    public CommentVO(
            @JsonProperty("postId") int postId,
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("body") String body) {


        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}

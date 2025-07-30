package model;

import java.util.Objects;

public class PostVO {
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public PostVO(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public PostVO() {
        // Default constructor for deserialization
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PostVO postVO)) return false;
        return getUserId() == postVO.getUserId() && getId() == postVO.getId() && Objects.equals(getTitle(), postVO.getTitle()) && Objects.equals(getBody(), postVO.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getId(), getTitle(), getBody());
    }

    @Override
    public String toString() {
        return "PostVO{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

package model.Todo;

public class TodoVOBuilder {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
    private String body;

    public TodoVOBuilder withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public TodoVOBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public TodoVOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public TodoVOBuilder withCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }

    public TodoVOBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public TodoVO build() {
        return new TodoVO(userId, id, title, completed, body);
    }
}

package model.Todo;

import java.util.concurrent.ThreadLocalRandom;

public class TodoVORequestFactory {
    public static TodoVORequest randomTodoVORequest() {
        int userId = ThreadLocalRandom.current().nextInt(1, 11);
        String title = "Todo title " + System.currentTimeMillis();
        boolean completed = ThreadLocalRandom.current().nextBoolean();
        String body = "Todo body " + System.currentTimeMillis();
        return new TodoVORequest(userId, title, completed, body);
    }
}

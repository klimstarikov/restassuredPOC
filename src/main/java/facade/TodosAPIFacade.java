package facade;

import api.TodosAPIImpl;
import io.restassured.response.Response;
import model.Todo.TodoVO;
import model.Todo.TodoVORequest;

import java.util.List;

public class TodosAPIFacade {
    private final TodosAPIImpl todosAPIImpl;

    public TodosAPIFacade() {
        this.todosAPIImpl = new TodosAPIImpl();
    }

    public TodoVO getTodoById(int id) {
        return todosAPIImpl.getTodoById(id)
                .then()
                .extract()
                .as(TodoVO.class);
    }

    public List<TodoVO> getTodosByUserId(int userId) {
        return todosAPIImpl.getTodosByUserId(userId)
                .then()
                .extract()
                .jsonPath()
                .getList("", TodoVO.class);
    }

    public Response postNewTodo(TodoVORequest body) {
        return todosAPIImpl.postNewTodo(body)
                .then()
                .extract()
                .response();
    }

    public Response updateTodoById(int todoId, TodoVORequest body) {
        return todosAPIImpl.updateTodoById(todoId, body)
                .then()
                .extract()
                .response();
    }

    public Response deleteTodoById(int todoId) {
        return todosAPIImpl.deleteTodoById(todoId)
                .then()
                .extract()
                .response();
    }
}


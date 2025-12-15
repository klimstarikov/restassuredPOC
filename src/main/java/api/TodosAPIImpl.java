package api;

import io.restassured.response.Response;
import model.Todo.TodoVORequest;

import static io.restassured.RestAssured.given;
import static utils.SpecFactory.requestSpec;

public class TodosAPIImpl {
    public Response getTodoById(int id) {
        return given()
                .spec(requestSpec())
                .pathParam("id", id)
                .when()
                .get("/todos/{id}");
    }

    public Response getAllTodos() {
        return given()
                .spec(requestSpec())
                .when()
                .get("/todos");
    }

    public Response getTodosByUserId(int userId) {
        return given()
                .spec(requestSpec())
                .queryParam("userId", userId)
                .when()
                .get("/todos");
    }

    public Response postNewTodo(TodoVORequest body) {
        return given()
                .spec(requestSpec())
                .body(body)
                .when()
                .post("/todos");
    }

    public Response updateTodoById(int todoId, TodoVORequest body) {
        return given()
                .spec(requestSpec())
                .pathParam("todoId", todoId)
                .body(body)
                .when()
                .put("/todos/{todoId}");
    }

    public Response deleteTodoById(int todoId) {
        return given()
                .spec(requestSpec())
                .pathParam("todoId", todoId)
                .when()
                .delete("/todos/{todoId}");
    }
}


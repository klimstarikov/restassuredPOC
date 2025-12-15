package tests.Positive;

import facade.TodosAPIFacade;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.Todo.TodoVO;
import model.Todo.TodoVORequest;
import model.Todo.TodoVORequestFactory;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Epic("Todo API Tests")
@Feature("Todo Feature")
public class TodosTest extends BaseTest {
    private final TodosAPIFacade todosAPIFacade = new TodosAPIFacade();

    @Test
    @Story("Get todo by id")
    public void getTodoById() {
        TodoVO todo = todosAPIFacade.getTodoById(1);
        Assert.assertEquals(todo.getId(), 1);
    }

    @Test
    @Story("Get todos by user id")
    public void getTodosByUserId() {
        List<TodoVO> todos = todosAPIFacade.getTodosByUserId(1);
        Assert.assertNotNull(todos);
        Assert.assertFalse(todos.isEmpty());
        Assert.assertTrue(todos.stream().allMatch(t -> t.getUserId() == 1));
    }

    @Test
    @Story("Create todo")
    public void createTodo() {
        TodoVORequest request = TodoVORequestFactory.randomTodoVORequest();
        todosAPIFacade.postNewTodo(request)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("schema/todo-schema.json"));
    }
}


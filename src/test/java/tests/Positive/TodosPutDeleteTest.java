package tests.Positive;

import facade.TodosAPIFacade;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.Post.PostVO;
import model.Post.PostVOBuilder;
import model.Post.PostVORequest;
import model.Post.PostVORequestFactory;
import model.Todo.TodoVO;
import model.Todo.TodoVOBuilder;
import model.Todo.TodoVORequest;
import model.Todo.TodoVORequestFactory;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

@Epic("Todo API Tests")
@Feature("Todo Put/Delete Feature")
public class TodosPutDeleteTest extends BaseTest {
    private final TodosAPIFacade todosAPIFacade = new TodosAPIFacade();

    @Test
    @Story("POST todo")
    public void PostTodoById() {
        TodoVORequest request = TodoVORequestFactory.randomTodoVORequest();
        TodoVO actual = todosAPIFacade.postNewTodo(request)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .as(TodoVO.class);

        TodoVO expected = new TodoVOBuilder()
                .withId(actual.getId())
                .withUserId(request.getUserId())
                .withTitle(request.getTitle())
                .withCompleted(request.isCompleted())
                .withBody(request.getBody())
                .build();

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Update todo with random fileds and verify response")
    @Parameters({"postId"})
    @Story("Update Todo Story")
    public void putRandomTodo(int postId) {
        TodoVORequest body = TodoVORequestFactory.randomTodoVORequest();
        TodoVO actualResponse = todosAPIFacade.updateTodoById(postId, body)
                .then()
                .statusCode(200)
                .extract()
                .as(TodoVO.class);

        TodoVO expectedResponse = new TodoVOBuilder()
                .withId(actualResponse.getId())
                .withBody(body.getBody())
                .withTitle(body.getTitle())
                .withUserId(body.getUserId())
                .build();

        Assert.assertEquals(expectedResponse, actualResponse, "Expected response does not match actual response");
    }

    @Test
    @Story("Delete todo by id")
    public void deleteTodoById() {
        todosAPIFacade.deleteTodoById(1)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}


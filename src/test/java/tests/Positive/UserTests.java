package tests.Positive;

import facade.UserFacade;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.User.UserTO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import model.User.UserFactory;
import tests.BaseTest;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Epic("User API Tests")
@Feature("Get User by ID Feature")
public class UserTests extends BaseTest {
    private UserTO expected;
    UserFacade userFacade = new UserFacade();

    @BeforeClass(description = "Prepare test user")
    public void setUp() {
        expected = UserFactory.minimalUser(1, "Leanne Graham");
    }

    @Test
    @Story("Get User by ID Story")
    public void getUserById() {
        UserTO actual = userFacade.getUserById(expected.getId());
        assert actual.equals(expected) : "Expected user does not match actual user";
    }


    @Test
    @Story("Validate User Schema Story")
    public void validateUserSchema() {
        userFacade.getUserByIdDefault(expected.getId())
                .body(matchesJsonSchemaInClasspath("schema/user-schema.json"));
    }
}

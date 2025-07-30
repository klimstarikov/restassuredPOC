package tests;

import facade.UserFacade;
import model.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testdata.UserFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserTests {
    private UserTO expected;
    UserFacade userFacade = new UserFacade();

    @BeforeClass(description = "Prepare test user")
    public void setUp() {
        expected = UserFactory.minimalUser(1, "Leanne Graham");
    }

    @Test
    public void getUserById() {
        UserTO actual = userFacade.getUserById(expected.getId());
        assert actual.equals(expected) : "Expected user does not match actual user";
    }


    @Test
    public void validateUserSchema() {
        userFacade.getUserByIdDefault(expected.getId())
                .body(matchesJsonSchemaInClasspath("schema/user-schema.json"));
    }
}

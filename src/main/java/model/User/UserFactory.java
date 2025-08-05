package model.User;

public class UserFactory {
    public static UserTO minimalUser(int id, String name) {
        return new UserTOBuilder().withId(id).withUsername(name).build();
    }
}

package testdata;

import model.UserTO;
import model.UserTOBuilder;

public class UserFactory {
    public static UserTO defaultUser(){
        return new UserTOBuilder().build();
    }
    public static UserTO minimalUser(int id, String name) {
        return new UserTOBuilder().withId(id).withUsername(name).build();
    }
}

package util;

import model.TestUser;

import java.util.UUID;

public class UserGenerator {

    public static TestUser randomUser() {
        String id = UUID.randomUUID().toString();
        return new TestUser(
                "user_" + id + "@mail.ru",
                "password123",
                "name_" + id
        );
    }

    public static TestUser userWithShortPassword() {
        return new TestUser(
                "short@mail.ru",
                "123",
                "short"
        );
    }
}
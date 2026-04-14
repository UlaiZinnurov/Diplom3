package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import model.TestUser;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String BASE_URL =
            "https://stellarburgers.education-services.ru";

    @Step("Регистрация пользователя через API")
    public ValidatableResponse register(TestUser user) {
        return given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(user)
                .post("/api/auth/register")
                .then();
    }

    @Step("Удаление пользователя по accessToken через API")
    public void delete(String accessToken) {
        given()
                .baseUri(BASE_URL)
                .header("Authorization", accessToken)
                .delete("/api/auth/user");
    }
}
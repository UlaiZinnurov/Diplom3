import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import util.UserGenerator;

import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Before
    public void prepareUser() {
        user = UserGenerator.randomUser();
        accessToken = userApi.register(user)
                .extract()
                .path("accessToken");
    }

    @Test
    @DisplayName("Вход через кнопку Войти в аккаунт на главной")
    @Description("Проверка входа через кнопку Войти в аккаунт на главной странице")
    public void loginFromMainButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(loginPage.isLoginSuccessful());
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    @Description("Проверка входа через кнопку Личный кабинет на главной странице")
    public void loginFromPersonalAccountTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(loginPage.isLoginSuccessful());
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    @Description("Проверка входа через ссылку в форме регистрации")
    public void loginFromRegistrationFormTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();
        loginPage.returnToLoginPage();

        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(loginPage.isLoginSuccessful());
    }

    @Test
    @DisplayName("Вход через форму восстановления пароля")
    @Description("Проверка входа через ссылку в форме восстановления пароля")
    public void loginFromForgotPasswordFormTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToForgotPassword();
        loginPage.returnToLoginPage();

        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(loginPage.isLoginSuccessful());
    }
}
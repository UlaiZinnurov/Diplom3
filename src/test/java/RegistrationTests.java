import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.TestUser;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import util.UserGenerator;

import static org.junit.Assert.assertTrue;

public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка успешной регистрации нового пользователя")
    public void successfulRegistrationTest() {
        user = UserGenerator.randomUser();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register(
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );

        assertTrue(registrationPage.isRegistrationSuccessful());

        loginPage.login(user.getEmail(), user.getPassword());

        accessToken = registrationPage.getAccessToken();
    }

    @Test
    @DisplayName("Регистрация с коротким паролем")
    @Description("Проверка ошибки при регистрации с паролем менее 6 символов")
    public void registrationWithShortPasswordTest() {
        TestUser shortPasswordUser = UserGenerator.userWithShortPassword();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register(
                shortPasswordUser.getName(),
                shortPasswordUser.getEmail(),
                shortPasswordUser.getPassword()
        );

        assertTrue(registrationPage.isPasswordErrorDisplayed());
    }
}
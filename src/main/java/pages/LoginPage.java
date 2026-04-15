package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailInput = By.name("name");
    private By passwordInput = By.name("Пароль");
    private By loginButton = By.xpath("//button[text()='Войти']");
    private By registerLink = By.linkText("Зарегистрироваться");
    private By forgotPasswordLink = By.linkText("Восстановить пароль");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод email и пароля и клик по кнопке Войти")
    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Успешный вход пользователя")
    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("/");
    }

    @Step("Переход на страницу регистрации")
    public void goToRegister() {
        driver.findElement(registerLink).click();
    }

    @Step("Переход на страницу восстановления пароля")
    public void goToForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }

    @Step("Возврат на страницу логина")
    public void returnToLoginPage() {
        driver.navigate().back();
    }
}
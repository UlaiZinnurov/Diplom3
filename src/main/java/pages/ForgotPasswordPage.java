package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    private By loginLink = By.linkText("Войти");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Возврат на страницу логина с формы восстановления пароля")
    public void returnToLogin() {
        driver.findElement(loginLink).click();
    }
}
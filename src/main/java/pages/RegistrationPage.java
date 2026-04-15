package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;

    private By nameInput =
            By.xpath("//label[text()='Имя']/following::input[1]");

    private By emailInput =
            By.xpath("//label[text()='Email']/following::input[1]");

    private By passwordInput =
            By.xpath("//label[text()='Пароль']/following::input[1]");

    private By registerButton =
            By.xpath("//button[text()='Зарегистрироваться']");

    private By passwordError =
            By.xpath("//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Регистрация пользователя")
    public void register(String name, String email, String password) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    @Step("Проверка отображения ошибки некорректного пароля")
    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(passwordError).isDisplayed();
    }

    @Step("Проверка успешной регистрации")
    public boolean isRegistrationSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.urlContains("/login"));
    }

    @Step("Получение accessToken из localStorage")
    public String getAccessToken() {
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return localStorage.getItem('accessToken');");
    }
}
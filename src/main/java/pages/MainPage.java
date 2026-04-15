package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Войти в аккаунт на главной")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonalAccount() {
        driver.findElement(personalAccountButton).click();
    }
}
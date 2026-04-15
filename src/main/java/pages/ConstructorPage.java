package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {

    private WebDriver driver;

    private By bunsTab = By.xpath("//span[text()='Булки']");
    private By saucesTab = By.xpath("//span[text()='Соусы']");
    private By fillingsTab = By.xpath("//span[text()='Начинки']");
    private By activeTab = By.xpath("//div[contains(@class,'tab_tab_type_current')]");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    private String getActiveTabText() {
        return driver.findElement(activeTab).getText();
    }

    @Step("Переключение на вкладку Булки")
    public String clickBuns() {
        if (getActiveTabText().equals("Булки")) {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(saucesTab))
                    .click();
        }

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bunsTab))
                .click();

        return getActiveTabText();
    }

    @Step("Переключение на вкладку Соусы")
    public String clickSauces() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(saucesTab))
                .click();
        return getActiveTabText();
    }

    @Step("Переключение на вкладку Начинки")
    public String clickFillings() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fillingsTab))
                .click();
        return getActiveTabText();
    }

}
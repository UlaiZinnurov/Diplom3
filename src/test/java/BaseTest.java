import api.UserApi;
import driver.WebDriverFactory;
import io.qameta.allure.Step;
import model.TestUser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;
    protected UserApi userApi = new UserApi();
    protected TestUser user;
    protected String accessToken;

    @Step("Настройка браузера перед тестом")
    @Before
    public void setUp() {
        driver = WebDriverFactory.create();
        driver.get("https://stellarburgers.education-services.ru");
    }

    @Step("Очистка данных после теста")
    @After
    public void tearDown() {
        if (accessToken != null) {
            userApi.delete(accessToken);
        }
        driver.quit();
    }
}
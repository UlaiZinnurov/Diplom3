import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.ConstructorPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTests extends BaseTest {

    @Test
    @DisplayName("Переключение на вкладку Булки")
    @Description("Проверка переключения на вкладку Булки")
    public void bunsTabTest() {
        ConstructorPage page = new ConstructorPage(driver);
        assertEquals("Булки", page.clickBuns());
    }

    @Test
    @DisplayName("Переключение на вкладку Соусы")
    @Description("Проверка переключения на вкладку Соусы")
    public void saucesTabTest() {
        ConstructorPage page = new ConstructorPage(driver);
        assertEquals("Соусы", page.clickSauces());
    }

    @Test
    @DisplayName("Переключение на вкладку Начинки")
    @Description("Проверка переключения на вкладку Начинки")
    public void fillingsTabTest() {
        ConstructorPage page = new ConstructorPage(driver);
        assertEquals("Начинки", page.clickFillings());
    }

}
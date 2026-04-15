package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverFactory {

    public static WebDriver create() {

        String browser = System.getProperty("browser", "chrome");

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "yandex":
                driver = createYandexDriver();
                break;
            case "chrome":
            default:
                driver = createChromeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createYandexDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        String yandexBinary = System.getProperty("yandex.binary");

        if (yandexBinary != null && !yandexBinary.isEmpty()) {
            options.setBinary(yandexBinary);
        } else {
            throw new RuntimeException(
                    "Для запуска Yandex укажи путь: -Dyandex.binary=ПУТЬ_К_BROWSER.EXE"
            );
        }

        return new ChromeDriver(options);
    }
}
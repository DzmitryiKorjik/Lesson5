package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class AbstractLiveJournalTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Установка пути к драйверу
        WebDriverManager.chromedriver().setup();

        // Создание экземпляра ChromeOptions и включение режима инкогнито
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");

        // Инициализация экземпляра драйвера Chrome с настройками инкогнито
        driver = new ChromeDriver(options);

        // Максимизация окна браузера
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        // Закрытие WebDriver и освобождение ресурсов
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}


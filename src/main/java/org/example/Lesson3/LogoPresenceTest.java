package org.example.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogoPresenceTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Создание экземпляра ChromeOptions и настройка опций
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        // Создание экземпляра WebDriver с переданными опциями
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.livejournal.com/");

            // Проверка наличия логотипа
            WebElement logoElement = driver.findElement(By.cssSelector(".lj_logo img"));
            boolean isLogoDisplayed = logoElement.isDisplayed();

            if (isLogoDisplayed) {
                System.out.println("Тест пройден. Логотип присутствует на главной странице.");
            } else {
                System.out.println("Тест не пройден. Логотип отсутствует на главной странице.");
            }

            driver.quit();
        } catch (Exception e) {
            System.out.println("Не удалось выполнить тест.");
            e.printStackTrace();
        }
    }
}


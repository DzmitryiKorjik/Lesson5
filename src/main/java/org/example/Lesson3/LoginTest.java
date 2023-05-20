package org.example.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
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

            // Клик по кнопке "Вход"
            WebElement loginButton = driver.findElement(By.linkText("Вход"));
            loginButton.click();

            // Ввод данных для входа
            WebElement usernameField = driver.findElement(By.name("user"));
            usernameField.sendKeys("Korjik527");

            WebElement passwordField = driver.findElement(By.name("lj_loginwidget_password"));
            passwordField.sendKeys("Korjik@Dzmitryi");

            // Отправка формы
            WebElement loginForm = driver.findElement(By.id("lj_loginwidget_form"));
            loginForm.submit();

            // Проверка успешного входа
            boolean isLoggedIn = driver.findElement(By.cssSelector(".b-mainpage-profile .b-ljuser")).isDisplayed();

            if (isLoggedIn) {
                System.out.println("Тест пройден. Успешный вход в аккаунт.");
            } else {
                System.out.println("Тест не пройден. Не удалось войти в аккаунт.");
            }

            driver.quit();
        } catch (Exception e) {
            System.out.println("Не удалось выполнить тест.");
            e.printStackTrace();
        }
    }
}


package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends AbstractLiveJournalTest {

    @Test
    public void testSuccessfulLogin() {
        // Шаг 1: Открываем страницу LiveJournal
        getDriver().get("https://www.livejournal.com/");

        // Шаг 2: Нажимаем на кнопку "Войти"
        WebElement loginButton = getDriver().findElement(By.className("s-header-item__link--login"));
        loginButton.click();

        // Шаг 3: Вводим учетные данные и нажимаем кнопку "Войти"
        WebElement usernameInput = getDriver().findElement(By.id("username"));
        usernameInput.sendKeys("Korjik527");
        WebElement passwordInput = getDriver().findElement(By.id("password"));
        passwordInput.sendKeys("Korjik@Dzmitryi");
        WebElement submitButton = getDriver().findElement(By.xpath("//input[@value='Войти']"));
        submitButton.click();

        // Шаг 4: Проверяем успешный вход в учетную запись
        WebElement userMenu = getDriver().findElement(By.id("usermenu"));
        Assertions.assertTrue(userMenu.isDisplayed(), "Не удалось выполнить успешный вход в учетную запись");
    }
}

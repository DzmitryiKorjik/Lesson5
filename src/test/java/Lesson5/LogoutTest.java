package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutTest extends AbstractLiveJournalTest {

    @Test
    public void testLogout() {
        // Шаг 1: Входим в учетную запись
        getDriver().get("https://www.livejournal.com/");
        WebElement loginButton = getDriver().findElement(By.className("s-header-item__link--login"));
        loginButton.click();
        WebElement usernameInput = getDriver().findElement(By.id("username"));
        usernameInput.sendKeys("Korjik527");
        WebElement passwordInput = getDriver().findElement(By.id("password"));
        passwordInput.sendKeys("Korjik@Dzmitryi");
        WebElement submitButton = getDriver().findElement(By.xpath("//input[@value='Войти']"));
        submitButton.click();

        // Шаг 2: Выходим из системы
        WebElement userMenu = getDriver().findElement(By.id("usermenu"));
        userMenu.click();
        WebElement logoutLink = getDriver().findElement(By.linkText("Выйти"));
        logoutLink.click();

        // Шаг 3: Проверяем успешный выход из системы
        WebElement loginButtonAfterLogout = getDriver().findElement(By.linkText("Войти"));
        Assertions.assertTrue(loginButtonAfterLogout.isDisplayed(), "Не удалось выполнить успешный выход из системы");
    }
}

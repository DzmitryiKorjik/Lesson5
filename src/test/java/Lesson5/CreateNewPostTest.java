package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateNewPostTest extends AbstractLiveJournalTest {

    @Test
    public void testCreateNewPost() {
        // Шаг 1: Открываем веб-сайт LiveJournal
        getDriver().get("https://www.livejournal.com/");

        // Шаг 2: Входим в учетную запись
        WebElement loginButton = getDriver().findElement(By.className("s-header-item__link--login"));
        loginButton.click();
        WebElement usernameInput = getDriver().findElement(By.id("username"));
        usernameInput.sendKeys("Korjik527");
        WebElement passwordInput = getDriver().findElement(By.id("password"));
        passwordInput.sendKeys("Korjik@Dzmitryi");
        WebElement submitButton = getDriver().findElement(By.xpath("//input[@value='Войти']"));
        submitButton.click();

        // Шаг 3: Переходим на страницу "Новый пост"
        WebElement newPostButton = getDriver().findElement(By.linkText("Новый пост"));
        newPostButton.click();

        // Шаг 4: Заполняем содержимое поста
        WebElement postTitleInput = getDriver().findElement(By.id("subject"));
        postTitleInput.sendKeys("Заголовок моего поста");
        WebElement postContentInput = getDriver().findElement(By.id("body"));
        postContentInput.sendKeys("Содержимое моего поста");

        // Шаг 5: Публикуем пост
        WebElement publishButton = getDriver().findElement(By.xpath("//input[@value='Опубликовать']"));
        publishButton.click();

        // Шаг 6: Проверяем успешное создание поста
        WebElement newPostElement = getDriver().findElement(By.xpath("//div[@class='entry']//h3[contains(text(),'Заголовок моего поста')]"));
        Assertions.assertNotNull(newPostElement, "Пост не создан или не отображается на странице");

    }
}

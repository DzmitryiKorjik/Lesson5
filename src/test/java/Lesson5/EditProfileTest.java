package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditProfileTest extends AbstractLiveJournalTest {

    @Test
    public void testEditProfile() {
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

        // Шаг 2: Переходим на страницу редактирования профиля
        WebElement userMenu = getDriver().findElement(By.id("Korjik527"));
        userMenu.click();
        WebElement profileLink = getDriver().findElement(By.linkText("Профиль"));
        profileLink.click();
        WebElement editProfileButton = getDriver().findElement(By.linkText("Редактировать профиль"));
        editProfileButton.click();

        // Шаг 3: Редактируем профиль
        WebElement firstNameInput = getDriver().findElement(By.id("first_name"));
        firstNameInput.clear();
        firstNameInput.sendKeys("Korjik");
        WebElement saveButton = getDriver().findElement(By.xpath("//input[@value='Сохранить']"));
        saveButton.click();

        // Шаг 4: Проверяем успешное редактирование профиля
        WebElement successMessage = getDriver().findElement(By.xpath("//div[@class='b-profile-edit__message']"));
        Assertions.assertTrue(successMessage.isDisplayed(), "Профиль не был успешно отредактирован");
    }
}


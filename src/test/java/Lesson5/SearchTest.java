package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchTest extends AbstractLiveJournalTest {

    @Test
    public void testSearchFunctionality() {
        // Шаг 1: Открываем страницу LiveJournal
        getDriver().get("https://www.livejournal.com/");

        // Шаг 2: Вводим запрос в поле поиска
        WebElement searchInput = getDriver().findElement(By.className("svgicon flaticon flaticon--search"));
        searchInput.sendKeys("Кино");
        searchInput.sendKeys(Keys.ENTER);

        // Шаг 3: Проверяем результаты поиска
        WebElement searchResults = getDriver().findElement(By.id("search-results"));
        Assertions.assertTrue(searchResults.isDisplayed(), "Результаты поиска не отображаются");
    }
}



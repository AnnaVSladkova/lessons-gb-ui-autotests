package ru.gb.lesson.lesson6_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.gb.lesson.lesson6_1.pages.BasePage;
import ru.gb.lesson.lesson6_1.pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Поиск на сайте mail.ru")
public class SearchTest extends BaseTest {


    @Test
    @DisplayName("Успешный поиск по заданному слову")
    void successfulSearchTest() {

        super.webDriver.get(super.url);
        BasePage basePage = new BasePage(super.webDriver);
        SearchPage searchPage = basePage.getSearchPage();

        searchPage.search("гороскоп на 2022");

        webDriver.findElement(By.xpath("//a[@data-pxt=\"c4|http://astroscope.ru/horoskop/goroskopi_na_god/2022.html|1|extern\"]")).click();

        String exp_title="гороскопы на 2022 год";
        String window_title= webDriver.getTitle();
        assertFalse(window_title.contains(exp_title));

    }

    @Test
    @DisplayName("Ничего не найдено")
    void failedSearchTest() {

        super.webDriver.get(super.url);
        BasePage basePage = new BasePage(super.webDriver);
        SearchPage searchPage = basePage.getSearchPage();

        searchPage.search("+");

        webDriver.findElement(By.xpath("//h2[@class=\"NotFound-title\"]"));

        String exp_title="ничего не найдено";
        String window_title= webDriver.getTitle();
        assertTrue(window_title.contains(exp_title));
    }
}
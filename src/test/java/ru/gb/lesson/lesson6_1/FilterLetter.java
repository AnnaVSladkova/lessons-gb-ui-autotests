package ru.gb.lesson.lesson6_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6_1.pages.AuthPage;
import ru.gb.lesson.lesson6_1.pages.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Поиск письма в почтовом ящике mail.ru")
    public class FilterLetter extends BaseTest {

    @Test
    @DisplayName("Успешнный поиск избранных писем")
    void successfulFilterSearchTest() throws InterruptedException {
        super.webDriver.get(super.url);
        BasePage basePage = new BasePage(super.webDriver);
        AuthPage authPage = basePage.getAuthPage(super.login, super.pass);
        authPage.sortWithFlag();

        String expected_url = "https://e.mail.ru/inbox/?filter_flagged=1";
        String current_url = webDriver.getCurrentUrl();
        assertTrue(expected_url.equals(current_url), "URL assert Ok");
    }

    @Test
    @DisplayName("Писем не найдено")
    void filedFilterSearchTest() throws InterruptedException {
        super.webDriver.get(super.url);
        BasePage basePage = new BasePage(super.webDriver);
        AuthPage authPage = basePage.getAuthPage(super.login, super.pass);
        authPage.searchOrders();

        String exp_title = "Поиск - Почта Mail.ru";
        String window_title = webDriver.getTitle();
        assertTrue(window_title.contains(exp_title));
    }
}
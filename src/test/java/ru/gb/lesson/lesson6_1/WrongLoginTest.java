package ru.gb.lesson.lesson6_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6_1.pages.AuthPage;
import ru.gb.lesson.lesson6_1.pages.BasePage;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Авторизация в почтовом ящике mail.ru")
public class WrongLoginTest extends BaseTest {

    @DisplayName("Неверный пароль в почтовом ящике mail.ru")
    @Test
    void  incorrectPasswordTest(){
        super.webDriver.get(super.url);
        BasePage basePage = new BasePage(super.webDriver);
        AuthPage authPage = basePage.getAuthPage(super.login, "123");

        String exp_title="Ошибка входа";
        String window_title= webDriver.getTitle();
        assertFalse(window_title.contains(exp_title));
    }

}

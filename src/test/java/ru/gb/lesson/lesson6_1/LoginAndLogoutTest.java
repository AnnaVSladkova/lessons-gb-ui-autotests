package ru.gb.lesson.lesson6_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6_1.pages.AuthPage;
import ru.gb.lesson.lesson6_1.pages.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Авторизация в почтовом ящике mail.ru")
public class LoginAndLogoutTest extends BaseTest {

    @Test
    @DisplayName("Успешная авторизация существующего пользователя и выход")
    void successfulAuthAndLogoutTest(){
        super.webDriver.get(super.url);
        BasePage basePage = new BasePage(super.webDriver);
        AuthPage authPage = basePage.getAuthPage(super.login, super.pass);

        String exp_username="sineglazka.seregina@mail.ru";
        String username_from_browser = authPage.getUserName();
        assertTrue(username_from_browser.contains(exp_username));
    }

}

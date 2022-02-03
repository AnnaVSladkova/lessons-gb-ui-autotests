package ru.gb.lesson.lesson6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Авторизация в почтовом ящике mail.ru")
public class LoginAndLogoutTest extends BaseAuthCorrectTest {

    @Test
    @DisplayName("Успешная авторизация существующего пользователя и выход")
    void successfulAuthAndLogoutTest(){
        String exp_username="sineglazka.seregina@mail.ru";
        String username_from_browser = webDriver.findElement(By.xpath("//span[text()='sineglazka.seregina@mail.ru']")).getText();
        assertTrue(username_from_browser.contains(exp_username));
    }

}

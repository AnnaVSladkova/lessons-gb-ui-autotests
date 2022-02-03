package ru.gb.lesson.lesson6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Авторизация в почтовом ящике mail.ru")
public class WrongLoginTest extends BaseAuthWrongTest {

     @DisplayName("Неверный пароль в почтовом ящике mail.ru")
    @Test
    void  incorrectPasswordTest(){
        String exp_title="Ошибка входа";
        String window_title= webDriver.getTitle();
        assertFalse(window_title.contains(exp_title));
    }

}

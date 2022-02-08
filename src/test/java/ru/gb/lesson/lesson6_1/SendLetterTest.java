package ru.gb.lesson.lesson6_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.gb.lesson.lesson6_1.pages.AuthPage;
import ru.gb.lesson.lesson6_1.pages.BasePage;
import ru.gb.lesson.lesson6_1.pages.SendLetterPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Отправка письма авторизованным пользователем mail.ru")
public class SendLetterTest extends BaseTest {

    @Test
    @DisplayName("Успешная отправка письма пользователем")
    void successfulSendLetterTest() throws IOException, InterruptedException {

        super.webDriver.get(super.url);
        BasePage basePage = new BasePage(super.webDriver);
        AuthPage authPage = basePage.getAuthPage(super.login, super.pass);
        SendLetterPage sendLetterPage = authPage.getSendLetterPage();

        String exp_title = "Входящие";
        String window_title = webDriver.getTitle();
        assertTrue(window_title.contains(exp_title));

        sendLetterPage.setTo("sineglazka.seregina@mail.ru");
        sendLetterPage.setSubject("Test");
        sendLetterPage.setBody("Test body");
        sendLetterPage.send();
    }

    @Test
    @DisplayName("Неуспешная отправка письма пользователем")
    void failedSendLetterTest() {

        super.webDriver.get(super.url);
        BasePage basePage = new BasePage(super.webDriver);
        AuthPage authPage = basePage.getAuthPage(super.login, super.pass);
        SendLetterPage sendLetterPage = authPage.getSendLetterPage();

        String exp_title = "Входящие";
        String window_title = webDriver.getTitle();
        assertTrue(window_title.contains(exp_title));

        sendLetterPage.setSubject("Test");
        sendLetterPage.setBody("Test body");
        sendLetterPage.send();

        webDriver.findElement(By.xpath("//*[text()='Не указан адрес получателя']"));

    }
}
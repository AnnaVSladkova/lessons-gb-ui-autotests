package ru.gb.lesson.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Отправка письма авторизованным пользователем mail.ru")
public class SendLetterTest extends BaseAuthCorrectTest {

    @Test
    @DisplayName("Успешная отправка письма пользователем")
    void successfulSendLetterTest() throws IOException, InterruptedException {

         webDriver.findElement(By.xpath("//a[@title=\"Написать письмо\"]")).click();

        String exp_title="Входящие";
        String window_title= webDriver.getTitle();
        assertTrue(window_title.contains(exp_title));

        webDriver.findElement(By.xpath("//div[@data-type=\"to\"]//input")).sendKeys("sineglazka.seregina@mail.ru");
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).click();
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).sendKeys("Тест");
        webDriver.findElement(By.xpath("//div[@role=\"textbox\"]")).sendKeys("Тест");
        webDriver.findElement(By.xpath("//span[@title=\"Отправить\"]")).click();

        }

    @Test
    @DisplayName("Неуспешная отправка письма пользователем")
    void faildSendLetterTest(){



        String exp_button_new_letter="Написать письмо";
        String button_name_from_browser = webDriver.findElement(By.xpath("//span[text()='Написать письмо']")).getText();
        assertTrue(button_name_from_browser.contains(exp_button_new_letter));

        webDriver.findElement(By.xpath("//a[@title=\"Написать письмо\"]")).click();
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).click();
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).sendKeys("Тест");
        webDriver.findElement(By.xpath("//div[@role=\"textbox\"]")).sendKeys("Тест");
        webDriver.findElement(By.xpath("//span[@title=\"Отправить\"]")).click();
        webDriver.findElement(By.xpath("//*[text()='Не указан адрес получателя']"));


    }

}

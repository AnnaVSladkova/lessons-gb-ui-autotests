package ru.gb.lesson.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Поиск письма в почтовом ящике mail.ru")
    public class FilterLetter extends BaseAuthCorrectTest{

        @Test
        @DisplayName("Успешнный поиск избранных писем")
        void successfulFilterSearchTest() throws InterruptedException {


            webDriver.findElement(By.xpath("//div[@class=\"filters-control__arrow-down-icon\"]")).click();
            webDriver.findElement(By.xpath("//span[text()=\"С флажком\"]")).click();

            String expected_url="https://e.mail.ru/inbox/?filter_flagged=1";
            String current_url=webDriver.getCurrentUrl();
            assertTrue(expected_url.equals(current_url), "URL assert Ok");



        }
        @Test
        @DisplayName("Писем не найдено")
        void filedFilterSearchTest() throws InterruptedException {


            webDriver.findElement(By.xpath("//span[text()=\"Поиск по почте\"]")).click();
            webDriver.findElement(By.xpath("//span[text()=\"Заказы\"]")).click();
            webDriver.findElement(By.xpath("//span[text()=\"По вашему запросу ничего не найдено\"]")).click();

            String exp_title="Поиск - Почта Mail.ru";
            String window_title= webDriver.getTitle();
            assertTrue(window_title.contains(exp_title));


        }

    }
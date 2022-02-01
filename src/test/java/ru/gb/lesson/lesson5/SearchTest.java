package ru.gb.lesson.lesson5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Поиск на сайте mail.ru")
public class SearchTest {
    WebDriver webDriver;

    @BeforeEach
    void setup() {
        webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }


    @Test
    @DisplayName("Успешный поиск по заданному слову")
    void successfulSearchTest() {

        webDriver.get("https://mail.ru/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));
        webDriver.findElement(By.id("q")).sendKeys("гороскоп на 2022");
        webDriver.findElement(By.xpath("//button[@id=\"search:submit\"]")).click();
        webDriver.findElement(By.xpath("//a[@data-pxt=\"c4|http://astroscope.ru/horoskop/goroskopi_na_god/2022.html|1|extern\"]")).click();

        String exp_title="гороскопы на 2022 год";
        String window_title= webDriver.getTitle();
        assertFalse(window_title.contains(exp_title));

    }

    @Test
    @DisplayName("Ничего не найдено")
    void failedSearchTest() {

        webDriver.get("https://mail.ru/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));
        webDriver.findElement(By.id("q")).sendKeys("+");
        webDriver.findElement(By.xpath("//button[@id=\"search:submit\"]")).click();
        webDriver.findElement(By.xpath("//h2[@class=\"NotFound-title\"]"));

        String exp_title="ничего не найдено";
        String window_title= webDriver.getTitle();
        assertTrue(window_title.contains(exp_title));
    }
}
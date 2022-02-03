package ru.gb.lesson.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver webDriver;

    @BeforeEach
    void setup() {
        webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://mail.ru/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }


}
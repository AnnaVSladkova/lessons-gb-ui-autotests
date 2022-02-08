package ru.gb.lesson.lesson6_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected final  String url = "https://mail.ru/";
    protected final  String login = "sineglazka.seregina";
    protected final  String pass = "abcd1979";

    protected WebDriver webDriver;

    @BeforeEach
    void setUp() {
        webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().setSize(new Dimension(1300, 720));
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}

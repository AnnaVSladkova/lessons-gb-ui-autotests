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

@DisplayName("Авторизация в почтовом ящике mail.ru")
public class LoginAndLogoutTest{
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
    @DisplayName("Успешная авторизация существующего пользователя и выход")
    void successfulAuthAndLogoutTest(){

        webDriver.get("https://mail.ru/");
        webDriver.manage().window().setSize(new Dimension(1300,720));

        webDriver.findElement(By.xpath("//input[@data-testid='login-input']")).sendKeys("sineglazka.seregina");
        webDriver.findElement(By.xpath("//button[@data-testid=\"enter-password\"]")).click();
        webDriver.findElement(By.name("password")).sendKeys("abcd1979");
        webDriver.findElement(By.xpath("//button[@data-testid=\"login-to-mail\"]")).click();

        String exp_username="sineglazka.seregina@mail.ru";
        String username_from_browser = webDriver.findElement(By.xpath("//span[text()='sineglazka.seregina@mail.ru']")).getText();
        assertTrue(username_from_browser.contains(exp_username));

        webDriver.findElement(By.xpath("//div[@data-testid=\"whiteline-account\"]")).click();
        webDriver.findElement(By.xpath("//div[text()=\'Выйти\']")).click();

    }

    @DisplayName("Неверный пароль в почтовом ящике mail.ru")
    @Test
    void  incorrectPasswordTest(){
        webDriver.get("https://mail.ru/");
        webDriver.manage().window().setSize(new Dimension(1300,720));
        webDriver.findElement(By.xpath("//input[@data-testid='login-input']")).sendKeys("sineglazka.seregina");
        webDriver.findElement(By.xpath("//button[@data-testid=\"enter-password\"]")).click();
        webDriver.findElement(By.name("password")).sendKeys("abcd");
        webDriver.findElement(By.xpath("//button[@data-testid=\"login-to-mail\"]")).click();
        webDriver.findElement(By.xpath("//*[text()='Неверное имя или пароль']"));

        String exp_title="Ошибка входа";
        String window_title= webDriver.getTitle();
        assertFalse(window_title.contains(exp_title));
    }

}

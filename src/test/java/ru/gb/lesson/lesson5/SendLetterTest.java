package ru.gb.lesson.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Отправка письма авторизованным пользователем mail.ru")
public class SendLetterTest {
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
    @DisplayName("Успешная отправка письма пользователем")
    void successfulSendLetterTest() throws IOException, InterruptedException {
        webDriver.get("https://mail.ru/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.xpath("//input[@data-testid='login-input']")).sendKeys("sineglazka.seregina");
        webDriver.findElement(By.xpath("//button[@data-testid=\"enter-password\"]")).click();
        webDriver.findElement(By.name("password")).sendKeys("abcd1979");
        webDriver.findElement(By.xpath("//button[@data-testid=\"login-to-mail\"]")).click();
        webDriver.findElement(By.xpath("//a[@title=\"Написать письмо\"]")).click();

        String exp_title="Входящие";
        String window_title= webDriver.getTitle();
        assertTrue(window_title.contains(exp_title));

        webDriver.findElement(By.xpath("//div[@data-type=\"to\"]//input")).sendKeys("sineglazka.seregina@mail.ru");
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).click();
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).sendKeys("Тест");
        webDriver.findElement(By.xpath("//div[@role=\"textbox\"]")).sendKeys("Тест");
        webDriver.findElement(By.xpath("//span[@title=\"Отправить\"]")).click();
        webDriver.findElement(By.xpath("//div[@data-testid=\"whiteline-account\"]")).click();
        webDriver.findElement(By.xpath("//div[text()=\'Выйти\']")).click();

        }

    @Test
    @DisplayName("Неуспешная отправка письма пользователем")
    void faildSendLetterTest(){
        webDriver.get("https://mail.ru/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.xpath("//input[@data-testid='login-input']")).sendKeys("sineglazka.seregina");
        webDriver.findElement(By.xpath("//button[@data-testid=\"enter-password\"]")).click();
        webDriver.findElement(By.name("password")).sendKeys("abcd1979");
        webDriver.findElement(By.xpath("//button[@data-testid=\"login-to-mail\"]")).click();

        String exp_button_new_letter="Написать письмо";
        String button_name_from_browser = webDriver.findElement(By.xpath("//span[text()='Написать письмо']")).getText();
        assertTrue(button_name_from_browser.contains(exp_button_new_letter));

        webDriver.findElement(By.xpath("//a[@title=\"Написать письмо\"]")).click();
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).click();
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).sendKeys("Тест");
        webDriver.findElement(By.xpath("//div[@role=\"textbox\"]")).sendKeys("Тест");
        webDriver.findElement(By.xpath("//span[@title=\"Отправить\"]")).click();
        webDriver.findElement(By.xpath("//*[text()='Не указан адрес получателя']"));
        webDriver.findElement(By.xpath("//div[@data-testid=\"whiteline-account\"]")).click();
        webDriver.findElement(By.xpath("//div[text()=\'Выйти\']")).click();

    }

}

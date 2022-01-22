package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SendLetter {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://mail.ru/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.xpath("//input[@data-testid='login-input']")).sendKeys("sineglazka.seregina");
        webDriver.findElement(By.xpath("//button[@data-testid=\"enter-password\"]")).click();
        webDriver.findElement(By.name("password")).sendKeys("abcd1979");
        webDriver.findElement(By.xpath("//button[@data-testid=\"login-to-mail\"]")).click();
        webDriver.findElement(By.xpath("//a[@title=\"Написать письмо\"]")).click();
        webDriver.findElement(By.xpath("//div[@data-type=\"to\"]//input")).sendKeys("sineglazka.seregina@mail.ru");
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).click();
        webDriver.findElement(By.xpath("//input[@name=\"Subject\"]")).sendKeys("Тест");
        webDriver.findElement(By.xpath("//div[@role=\"textbox\"]")).sendKeys("Тест");
        webDriver.findElement(By.xpath("//span[@title=\"Отправить\"]")).click();
        webDriver.findElement(By.xpath("//div[@data-testid=\"whiteline-account\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[text()=\'Выйти\']")).click();

        webDriver.quit();
        }
}

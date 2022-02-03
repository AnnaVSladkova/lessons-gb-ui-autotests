package ru.gb.lesson.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Прогноз погоды на сайте mail.ru")
public class WeaterTest extends BaseTest {


    @Test
    @DisplayName("Погода на 14 дней в Москве")
    void successfulWeatherTest(){
        webDriver.findElement(By.xpath("//a[@class=\"weather__more svelte-x0ulz0\"]")).click();
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        webDriver.findElement(By.xpath("//a[text()=\"14 дней\"]")).click();

        String expected_url="https://pogoda.mail.ru/prognoz/moskva/14dney/";
        String current_url=webDriver.getCurrentUrl();
        assertTrue(expected_url.equals(current_url), "URL assert Ok");

    }
}

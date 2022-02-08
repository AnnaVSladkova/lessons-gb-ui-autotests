package ru.gb.lesson.lesson6_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6_1.pages.BasePage;
import ru.gb.lesson.lesson6_1.pages.WeatherPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Прогноз погоды на сайте mail.ru")
public class WeaterTest extends BaseTest {


    @Test
    @DisplayName("Погода на 14 дней в Москве")
    void successfulWeatherTest() {
        super.webDriver.get(super.url);
        BasePage basePage = new BasePage(super.webDriver);
        WeatherPage weatherPage = basePage.getWeatherPage();
        weatherPage.get14days();

        String expected_url = "https://pogoda.mail.ru/prognoz/moskva/14dney/";
        String current_url = webDriver.getCurrentUrl();
        assertTrue(expected_url.equals(current_url), "URL assert Ok");

    }
}

package ru.gb.lesson.lesson6_1.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lesson.lesson6_1.BaseView;

public class WeatherPage extends BaseView {

    @FindBy(xpath = "//a[text()=\"14 дней\"]")
    private WebElement forcast14days;

    public WeatherPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Посмотреть погоду на 14 дней")
    public void get14days(){
        this.forcast14days.click();
    }
}
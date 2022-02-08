package ru.gb.lesson.lesson6_1.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lesson.lesson6_1.BaseView;

import java.util.ArrayList;

public  class BasePage extends BaseView {

    @FindBy(xpath = "//input[@data-testid='login-input']")
    private WebElement loginInput;
    @FindBy(xpath = "//button[@data-testid=\"enter-password\"]")
    private WebElement enterPasswordButton;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@data-testid=\"login-to-mail\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@class=\"weather__more svelte-x0ulz0\"]")
    private WebElement weatherLink;

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step("Авторизация в почте")
    public AuthPage getAuthPage(String login, String pass){
        this.loginInput.sendKeys(login);
        this.enterPasswordButton.click();
        this.passwordInput.sendKeys(pass);
        this.loginButton.click();
        return new AuthPage(webDriver);
    }
    @Step("Просмотр прогноза погоды")
    public WeatherPage getWeatherPage(){
        this.weatherLink.click();
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        return new WeatherPage(webDriver);
    }
    @Step("Строка поиска по сайту")
    public SearchPage getSearchPage(){
        return new SearchPage(webDriver);
    }
}
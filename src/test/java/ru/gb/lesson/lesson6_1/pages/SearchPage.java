package ru.gb.lesson.lesson6_1.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lesson.lesson6_1.BaseView;

public class SearchPage extends BaseView {

    @FindBy(id = "q")
    private WebElement searchBox;
    @FindBy(xpath = "//button[@id=\"search:submit\"]")
    private WebElement searchButton;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Ввести слово для поиска")
    public void search(String criteria){
        this.searchBox.sendKeys(criteria);
        this.searchButton.click();
    }
}
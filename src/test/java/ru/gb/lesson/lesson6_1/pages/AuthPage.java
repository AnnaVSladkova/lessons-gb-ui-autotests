package ru.gb.lesson.lesson6_1.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lesson.lesson6_1.BaseView;

public class AuthPage extends BaseView {

    @FindBy(xpath = "//div[@class=\"filters-control__arrow-down-icon\"]")
    private WebElement getFilter;
    @FindBy(xpath = "//span[text()=\"С флажком\"]")
    private WebElement elementFilterWithFlag;

    @FindBy(xpath = "//span[text()=\"Поиск по почте\"]")
    private WebElement searchInPost;
    @FindBy(xpath = "//span[text()=\"Заказы\"]")
    private WebElement filterOrders;
    @FindBy(xpath = "//span[text()=\"По вашему запросу ничего не найдено\"]")
    private WebElement elementNotFound;

    @FindBy(xpath = "//span[contains(@class,'ph-project__user-name')]")
    private WebElement userNameElement;

    @FindBy(xpath = "//a[@title=\"Написать письмо\"]")
    private WebElement writeLetter;

    public AuthPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Сортировка писем с флажком")
    public void sortWithFlag() {
        getFilter.click();
        elementFilterWithFlag.click();
    }
    @Step("Сортировка писем с заказами")
    public void searchOrders() {
        searchInPost.click();
        filterOrders.click();
        elementNotFound.click();
    }

    public String getUserName() {
        return this.userNameElement.getText();
    }

    @Step("Отправка письма")
    public SendLetterPage getSendLetterPage() {
        this.writeLetter.click();
        return new SendLetterPage(super.webDriver);
    }
}
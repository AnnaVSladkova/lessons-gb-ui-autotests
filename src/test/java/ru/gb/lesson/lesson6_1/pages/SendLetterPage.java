package ru.gb.lesson.lesson6_1.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lesson.lesson6_1.BaseView;

public class SendLetterPage extends BaseView {

    @FindBy(xpath = "//div[@data-type=\"to\"]//input")
    private WebElement toInput;
    @FindBy(xpath = "//input[@name=\"Subject\"]")
    private WebElement subject;
    @FindBy(xpath = "//div[@role=\"textbox\"]")
    private WebElement body;
    @FindBy(xpath = "//span[@title=\"Отправить\"]")
    private WebElement sendButton;

    public SendLetterPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Ввести адрес")
    public void setTo(String address) {
        this.toInput.sendKeys(address);
    }
    @Step("Ввести тему сообщения")
    public void setSubject(String subject) {
        this.subject.click();
        this.subject.sendKeys(subject);
    }
    @Step("Написать текст письма")
    public void setBody(String body) {
        this.body.sendKeys(body);
    }
    @Step("Отправить письмо")
    public void send() {
        this.sendButton.click();
    }
}
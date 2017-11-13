package com.write.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends Page {


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 3);
    }

    @FindBy(id = "mailbox__auth__button")
    public WebElement buttonLogin;

    @FindBy(id = "mailbox__login")
    public WebElement fieldLogin;

    @FindBy(id = "mailbox__password")
    public WebElement fieldPassword;


    public void writeLogin(String login) {
        fieldLogin.clear();
        fieldLogin.sendKeys(login);
    }

    public void writePassword(String password) {
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
    }

    public HomePage clickLogin() {
        buttonLogin.click();
        return new HomePage(driver);
    }

    @Override
    public void open() {
        driver.get("https://mail.ru/");
    }

}

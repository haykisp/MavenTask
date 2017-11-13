package com.write.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 3);                                                                   // Defining wait time for driver (15 sec)
    }

    @FindBy(id = "PH_logoutLink")
    public WebElement buttonLogout;

    @FindBy(xpath = ".//span[text()=\"Написать письмо\"]")
    public WebElement buttonNewMessage;

    public LoginPage clickLogout() {
        buttonLogout.click();
        return new LoginPage(driver);
    }

    public MailPage clickButtonNewMessage() {
        buttonNewMessage.click();
        return new MailPage(driver);
    }

    public int countMails() {
        int count = 0;
        int i = 1;
        while (isMailExist(".//*[@class=\"b-datalist__body\"]/div[" + Integer.toString(i) + "]")) {
            count = i;
            i++;
        }
        return count;
    }

    public boolean isMailExist(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public void open() {
    }

}

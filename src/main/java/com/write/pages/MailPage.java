package com.write.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends Page {

    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 3);
    }

    @Override
    public void open() {
    }


    @FindBy(xpath = ".//textarea[@data-original-name=\"To\"]")
    public WebElement fieldAddress;

    @FindBy(name = "Subject")
    public WebElement fieldSubject;


    @FindBy(xpath = ".//div[@data-name=\"saveDraft\"]")
    public WebElement buttonSaveEmail;

    @FindBy(xpath =".//div[@data-name=\"send\"]")
    public WebElement buttonSendEmail;

    @FindBy(xpath = ".//div[@class=\"b-toolbar__message\"]")
    public WebElement textMailSaved;



    public void writeAddress(String Email) {
        fieldAddress.sendKeys(Email);
    }

    public void writeSubject(String Subject) {
        type(fieldSubject, Subject);
    }

    public void writeBody(String Body) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'toolkit')]")));
        WebElement body = driver.findElement(By.xpath("//*[@id='tinymce']"));
        body.clear();
        body.sendKeys(Body);
        driver.switchTo().defaultContent();
    }

    public void clickSaveEmail() {
        buttonSaveEmail.click();
    }

    public void clickSendEmail(){
        buttonSendEmail.click();
    }
}

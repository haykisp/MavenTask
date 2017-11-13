package com.write.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Page {

    WebDriver driver;
    protected WebDriverWait wait;

    Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void click(WebElement webElement) {
        webElement.click();
    }

    public abstract void open();

    public void waitToDisplay(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
        }
    }

}


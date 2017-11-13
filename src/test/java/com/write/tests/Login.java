package com.write.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Login extends BasicTestCase {


    @Test                                                                           // The following test checking login with valid Login and Password
    public void validLogin() {
        System.out.println("Starting Valid Login case");
        loginPage.open();
        loginPage.writeLogin(haykisp.name);
        loginPage.writePassword(haykisp.password);
        homePage = loginPage.clickLogin();
        homePage.waitToDisplay(homePage.buttonLogout);
        Assert.assertTrue(homePage.buttonLogout.isDisplayed());
    }

    @Test                                                                           // The Following test checking login with empty fields
    public void emptyLoginPassword() {
        System.out.println("Starting Empty Login&Password case");
        homePage = loginPage.clickLogin();
        homePage.waitToDisplay(homePage.buttonLogout);
        Assert.assertFalse(homePage.buttonLogout.isDisplayed());
    }

    @Test                                                                           // The following test checking login with valid login & empty password field
    public void emptyPassword() {
        System.out.println("Starting Empty Password case");
        loginPage.writeLogin(haykisp.name);
        homePage = loginPage.clickLogin();
        homePage.waitToDisplay(homePage.buttonLogout);
        Assert.assertFalse(homePage.buttonLogout.isDisplayed());
    }

    @Test                                                                           // The following test checking login with empty valid password & empty login
    public void emptyLogin() {
        System.out.println("Starting Empty Login case");
        loginPage.writePassword(haykisp.password);
        homePage = loginPage.clickLogin();
        homePage.waitToDisplay(homePage.buttonLogout);
        Assert.assertFalse(homePage.buttonLogout.isDisplayed());
    }
}

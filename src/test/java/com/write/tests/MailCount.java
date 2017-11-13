package com.write.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class MailCount extends BasicTestCase {

    @Test                                                           // The following test checking is there 3 inbox mails
    public void count() {
        loginPage.writeLogin(haykisp.name);
        loginPage.writePassword(haykisp.password);
        homePage = loginPage.clickLogin();
        homePage.waitToDisplay(homePage.buttonLogout);
        Assert.assertEquals(homePage.countMails(),3);
    }
}


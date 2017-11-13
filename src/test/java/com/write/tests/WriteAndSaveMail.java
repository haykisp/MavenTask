package com.write.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class WriteAndSaveMail extends BasicTestCase {



    @Test                                                                       // The following test check is written email saving
    public void writeMailAndSave() throws InterruptedException {
        System.out.println("Starting WriteMailAndSave case");
        loginPage.writeLogin(haykisp.name);
        loginPage.writePassword(haykisp.password);
        homePage = loginPage.clickLogin();
        homePage.waitToDisplay(homePage.buttonNewMessage);
        mailPage = homePage.clickButtonNewMessage();
        mailPage.waitToDisplay(mailPage.fieldSubject);
        mailPage.writeSubject("TestMail");
        mailPage.writeAddress("haykisp@gmail.com");
        mailPage.writeBody("This is a test Email to save");
        mailPage.clickSaveEmail();
        mailPage.waitToDisplay(mailPage.mailSaved);
        Assert.assertTrue(mailPage.mailSaved.isDisplayed());
    }

}

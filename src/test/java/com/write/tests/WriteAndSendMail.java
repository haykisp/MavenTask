package com.write.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;


public class WriteAndSendMail extends BasicTestCase {



    @Test                                                                       // The following test check is written email saving
    public void writeMailAndSend() throws InterruptedException {
        System.out.println("Starting WriteMailAndSave case");
        loginPage.writeLogin(haykisp.name);
        loginPage.writePassword(haykisp.password);
        homePage = loginPage.clickLogin();
        mailPage = homePage.clickButtonNewMessage();
        mailPage.writeSubject("TestMail");
        mailPage.writeAddress("haykisp@gmail.com");
        mailPage.writeBody("This is a test Email to save");
        mailPage.clickSendEmail();
    }

}

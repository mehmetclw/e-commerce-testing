package com.ecommerce.pages;

import com.ecommerce.elements.LoginFunctionalityElement;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import org.testng.asserts.SoftAssert;

public class LoginFunctionalityPage extends Utility {
    SoftAssert sf = new SoftAssert();
    LoginFunctionalityElement loginFunctionalityElement;
    public LoginFunctionalityPage(){
        loginFunctionalityElement= new LoginFunctionalityElement();
    }

    public void loginFunctionalityTest(){
        clickElement(loginFunctionalityElement.signInLink);
        waits(2);
        sendKeyToElement(loginFunctionalityElement.email, ConfigReader.getProperty("userEmailEC-4"));
        waits(1);
        sendKeyToElement(loginFunctionalityElement.password,ConfigReader.getProperty("userPasswordEC-4"));
        clickElement(loginFunctionalityElement.signInButton);
        waits(3);
        String actualCheck = getTextElement(loginFunctionalityElement.accountCheck);
        String actualP = getTextElement(loginFunctionalityElement.pCheck);
        String expectedCheck = "MY ACCOUNT";
        String expectP = "Welcome to your account. Here you can manage all of your personal information and orders.";
        waits(1);
        sf.assertEquals(actualCheck, expectedCheck, "NO MATCH");
        sf.assertEquals(actualP, expectP, "NO MATCH");
        sf.assertAll();

    }
}

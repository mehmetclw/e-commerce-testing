package com.ecommerce.pages;

import com.ecommerce.elements.AccountManagementFunctionalityElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.testng.Assert;

public class AccountManagementFunctionalityPages extends Utility {

    AccountManagementFunctionalityElements amfe;

    public AccountManagementFunctionalityPages(){ amfe = new AccountManagementFunctionalityElements();}


    public String email = ConfigReader.getProperty("emailAddress1");
    public String password = ConfigReader.getProperty("password");
    public String userId=ConfigReader.getProperty("userId");

    public void accountUpdate() {
        String expectedTitle = "My Store";
        String actualTitle =  Driver.getDriver().getTitle();;
        Assert.assertEquals(actualTitle, expectedTitle, "Title didn't match");
        clickElement(amfe.clickOnSignIn);
        clickElement(amfe.enterEmail);
        sendKeyToElement(amfe.enterEmail, ConfigReader.getProperty("emailAddress1"));
        clickElement(amfe.enterPassword);
        sendKeyToElement(amfe.enterPassword, ConfigReader.getProperty("password"));
        clickElement(amfe.signInLink);
        waits(2);
        String actualText = getTextElement(amfe.verifySignIn);
        String expectedText = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assert.assertEquals(actualText, expectedText, "Titles are not matching");
        waits(1);

        clickElement(amfe.orderDetails);
        clickElement(amfe.checkHistoryOfOrder);
        String actualText1 =getTextElement(amfe.checkHistoryOfOrder);
        String expectedText1 = "Here are the orders you've placed since your account was created.";
        Assert.assertEquals(actualText1, expectedText1, "Titles are NOT matching");
        waits(2);

        Driver.getDriver().navigate().back();
        clickElement(amfe.checkPersonalInfo);
        clickElement(amfe.enterCurrentPassword);
        sendKeyToElement(amfe.enterCurrentPassword, ConfigReader.getProperty("password"));
        Utility.waits(5);
        clickElement(amfe.enterNewPassword);
        sendKeyToElement(amfe.enterNewPassword, ConfigReader.getProperty("password"));
        clickElement(amfe.confirmPassword);
        sendKeyToElement(amfe.confirmPassword, ConfigReader.getProperty("password"));
        clickElement(amfe.saveButton);
        waits(2);
        String actualTextInLine = getTextElement(amfe.checkUpdatedPassword);
        String expectedTextInLine = "Your personal information has been successfully updated.";
        Assert.assertEquals(actualTextInLine, expectedTextInLine, "Titles are nott matching");
        waits(2);

        clickElement(amfe.myAccountLink);
        clickElement(amfe.myAddressButton);
        clickElement(amfe.updateButton);
        clickElement(amfe.enterNewAddress);
        clearElement(amfe.enterNewAddress);
        sendKeyToElement(amfe.enterNewAddress, "12 Street");
        clickElement(amfe.saveButton);
        scrollTo(amfe.verifyChangedAddress);
        String actualTextLine = getTextElement(amfe.verifyChangedAddress);
        String expectedTextLine = "12 Street";
        Assert.assertEquals(actualTextLine, expectedTextLine, "Titles are NOTT matching");
        waits(2);
    }

    public void invalidFirstName() {
        clickElement(amfe.clickOnSignIn);
        clickElement(amfe.enterEmail);
        sendKeyToElement(amfe.enterEmail, ConfigReader.getProperty("emailAddress1"));
        clickElement(amfe.enterPassword);
        sendKeyToElement(amfe.enterPassword, ConfigReader.getProperty("password"));
        clickElement(amfe.signInLink);
        waits(3);

        String actualText = getTextElement(amfe.verifySignIn);
        String expectedText = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assert.assertEquals(actualText, expectedText, "Titles are not matching");

        clickElement(amfe.checkPersonalInfo);
        clickElement(amfe.changeFirstName);
        clearElement(amfe.changeFirstName);
        sendKeyToElement(amfe.changeFirstName, ConfigReader.getProperty("userId"));
        clickElement(amfe.enterCurrentPassword);
        sendKeyToElement(amfe.enterCurrentPassword,ConfigReader.getProperty("password"));
        waits(2);
        clickElement(amfe.enterNewPassword);
        sendKeyToElement(amfe.enterNewPassword,ConfigReader.getProperty("password"));
        clickElement(amfe.confirmPassword);
        sendKeyToElement(amfe.confirmPassword,ConfigReader.getProperty("password"));
        clickElement(amfe.saveButton);
        waits(2);
        String actualText1 = getTextElement(amfe.invalidFirstName);
        String expectedText1 = "firstname is invalid.";
        Assert.assertEquals(actualText1, expectedText1, "Titles are not matching");
    }

}
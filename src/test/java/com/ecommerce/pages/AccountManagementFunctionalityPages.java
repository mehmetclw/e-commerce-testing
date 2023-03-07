package com.ecommerce.pages;

import com.ecommerce.elements.AccountManagementFunctionalityElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.testng.Assert;

public class AccountManagementFunctionalityPages {

    AccountManagementFunctionalityElements amfe;

    public String email = ConfigReader.getProperty("emailAddress1");
    public String password = ConfigReader.getProperty("password");

    public void accountUpdate() {
        amfe = new AccountManagementFunctionalityElements();
        String expectedTitle = "My Store";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title didn't match");
        amfe.clickOnSignIn.click();
        amfe.enterEmail.click();
        amfe.enterEmail.sendKeys(email);
        amfe.enterPassword.click();
        amfe.enterPassword.sendKeys(password);
        amfe.signInLink.click();
        Utility.waits(3);
        String actualText = amfe.verifySignIn.getText();
        String expectedText = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assert.assertEquals(actualText, expectedText, "Titles are not matching");
        Utility.waits(1);

        amfe.orderDetails.click();
        amfe.checkHistoryOfOrder.click();
        String actualText1 = amfe.checkHistoryOfOrder.getText();
        String expectedText1 = "Here are the orders you've placed since your account was created.";
        Assert.assertEquals(actualText1, expectedText1, "Titles are NOT matching");
        Utility.waits(2);

        Driver.getDriver().navigate().back();
        amfe.checkPersonalInfo.click();
        amfe.enterCurrentPassword.click();
        amfe.enterCurrentPassword.sendKeys("123elifnur");
        Utility.waits(2);
        amfe.enterNewPassword.click();
        amfe.enterNewPassword.sendKeys("123elifnur");
        amfe.confirmPassword.click();
        amfe.confirmPassword.sendKeys("123elifnur");
        amfe.saveButton.click();
        Utility.waits(2);
        String actualTextInLine = amfe.checkUpdatedPassword.getText();
        String expectedTextInLine = "Your personal information has been successfully updated.";
        Assert.assertEquals(actualTextInLine, expectedTextInLine, "Titles are nott matching");
        Utility.waits(2);

        amfe.myAccountLink.click();
        amfe.myAddressButton.click();
        amfe.updateButton.click();
        amfe.enterNewAddress.click();
        amfe.enterNewAddress.clear();
        amfe.enterNewAddress.sendKeys("12 Street");
        amfe.saveButton.click();
        Utility.scrollTo(amfe.verifyChangedAddress);
        String actualTextLine = amfe.verifyChangedAddress.getText();
        String expectedTextLine = "12 Street";
        Assert.assertEquals(actualTextLine, expectedTextLine, "Titles are NOTT matching");
        Utility.waits(2);
    }

    public void invalidFirstName() {
        amfe = new AccountManagementFunctionalityElements();
        amfe.clickOnSignIn.click();
        amfe.enterEmail.click();
        amfe.enterEmail.sendKeys(email);
        amfe.enterPassword.click();
        amfe.enterPassword.sendKeys(password);
        amfe.signInLink.click();
        Utility.waits(3);

        String actualText = amfe.verifySignIn.getText();
        String expectedText = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assert.assertEquals(actualText, expectedText, "Titles are not matching");

        amfe.checkPersonalInfo.click();
        amfe.changeFirstName.click();
        amfe.changeFirstName.clear();
        amfe.changeFirstName.sendKeys("John1");
        amfe.enterCurrentPassword.click();
        amfe.enterCurrentPassword.sendKeys("123elifnur");
        Utility.waits(2);
        amfe.enterNewPassword.click();
        amfe.enterNewPassword.sendKeys("123elifnur");
        amfe.confirmPassword.click();
        amfe.confirmPassword.sendKeys("123elifnur");
        amfe.saveButton.click();
        Utility.waits(2);
        String actualText1 = amfe.invalidFirstName.getText();
        String expectedText1 = "firstname is invalid.";
        Assert.assertEquals(actualText1, expectedText1, "Titles are not matching");

    }

}
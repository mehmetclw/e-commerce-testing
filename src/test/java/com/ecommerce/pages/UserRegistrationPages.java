package com.ecommerce.pages;

import com.ecommerce.elements.UserRegistrationElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationPages extends Utility {

    UserRegistrationElements ure;

    /**
     * BrowserSetup
     */
    public String email = ConfigReader.getProperty("email");
    public String password = "";

    public void createNewAccount() {
        ure = new UserRegistrationElements();
        clickElement(ure.signInButton);
        clickElement(ure.emailAddress);
        sendKeyToElement(ure.emailAddress, email);
        clickElement(ure.createAccountButton);
        clickElement(ure.mrsCheckBox);
        clickElement(ure.firstName);
        sendKeyToElement(ure.firstName, "elif");
        clickElement(ure.lastName);
        sendKeyToElement(ure.lastName, "topal");
        sendKeyToElement(ure.password, "123elif");

        selectElementByValue(ure.day, "25");
        selectElementByIndex(ure.month, 1);
        selectElementByValue(ure.year, "1990");
        clickElement( ure.register);

    }

    public void createNewAccount(String userEmail, String userPassword, String firstName, String lastName) {
        ure = new UserRegistrationElements();
        ure.signInButton.click();
        ure.emailAddress.click();
        ure.emailAddress.sendKeys(userEmail);
        ure.createAccountButton.click();
        ure.mrsCheckBox.click();
        ure.firstName.click();
        ure.firstName.sendKeys(firstName);
        ure.lastName.click();
        ure.lastName.sendKeys(lastName);
        ure.password.sendKeys(userPassword);

        Select select = new Select(ure.day);
        select.selectByIndex(0);
        select.selectByValue("25");
        Select select2 = new Select(ure.month);
        select2.selectByIndex(0);
        select2.selectByValue("12");
        Select select3 = new Select(ure.year);
        select3.selectByIndex(0);
        select3.selectByValue("1990");
        ure.register.click();
        Driver.getDriver().findElement(By.xpath("//a[@class='logout']")).click();
    }
}

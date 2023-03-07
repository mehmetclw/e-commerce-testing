package com.ecommerce.pages;

import com.ecommerce.elements.UserRegistrationElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationNewPages {

    UserRegistrationElements ure;

    /**
     * BrowserSetup
     */
    public String email = ConfigReader.getProperty("email");
    public String password = "";

    public void createNewAccount() {
        ure = new UserRegistrationElements();
        ure.signInButton.click();
        ure.emailAddress.click();
        ure.emailAddress.sendKeys(email);
        ure.createAccountButton.click();
        ure.mrsCheckBox.click();
        ure.firstName.click();
        ure.firstName.sendKeys("elif");
        ure.lastName.click();
        ure.lastName.sendKeys("topal");
        ure.password.sendKeys("123elif");

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
    }

    public void createNewAccount(String userEmail, String userPassword,String firstName,String lastName) {
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

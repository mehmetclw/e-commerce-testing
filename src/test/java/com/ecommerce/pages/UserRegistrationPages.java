package com.ecommerce.pages;

import com.ecommerce.elements.UserRegistrationElements;
import com.ecommerce.utility.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class UserRegistrationPages {
    WebDriver driver;

    public UserRegistrationPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }


    @FindBy(xpath = "//div[@class='header_user_info']/a")
    public WebElement signInButton;

    /**
     * BrowserSetup
     */
    public String email = ConfigReader.getProperty("email");
    public String password = "";

    public void createNewAccount() {
        System.out.println("$$$$$$$$$$ "+driver !=null);
        UserRegistrationElements ure = new UserRegistrationElements(driver);
        signInButton.click();
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
}

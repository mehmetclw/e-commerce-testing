package com.ecommerce.elements;

import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountManagementFunctionalityElements {


    public AccountManagementFunctionalityElements(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    public WebElement clickOnSignIn;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement enterEmail;
    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement enterPassword;
    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement signInLink;
    @FindBy(xpath = "//p[@class='info-account']")
    public WebElement verifySignIn;
    @FindBy(xpath = "//span[text()='Order history and details']")
    public WebElement orderDetails;
    @FindBy(xpath = "//p[@class='info-title']")
    public WebElement checkHistoryOfOrder;
    @FindBy(xpath = "//span[text()='My personal information']")
    public WebElement checkPersonalInfo;
    @FindBy(xpath = "//input[@id='old_passwd']")
    public WebElement enterCurrentPassword;
    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement enterNewPassword;
    @FindBy(xpath = "//input[@id='confirmation']")
    public WebElement confirmPassword;
    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement checkUpdatedPassword;
    @FindBy(xpath = "//a[@itemprop='url']")
    public WebElement myAccountLink;
    @FindBy(xpath = "//span[text()='My addresses']")
    public WebElement myAddressButton;
    @FindBy(xpath = "//ul[@class='first_item item box']//span[text()='Update']")
    public WebElement updateButton;
    @FindBy(xpath = "//input[@id='address1']")
    public WebElement enterNewAddress;
    @FindBy(xpath = "//span[normalize-space()='12 Street']")
    public WebElement verifyChangedAddress;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement changeFirstName;

    @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    public WebElement invalidFirstName;

}

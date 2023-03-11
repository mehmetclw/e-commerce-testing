package com.ecommerce.elements.frontend;

import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsletterFunctionalityElements {
    public NewsletterFunctionalityElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "newsletter-input")
    public WebElement newsletterBar;
    @FindBy(name = "submitNewsletter")
    public WebElement newsletterButton;
    @FindBy(id = "inputEmail")
    public WebElement fakeEmail;
    @FindBy(id ="form-domain-id")
    public WebElement fakeSelector;
    @FindBy(id="fetch-mails")
    public WebElement fetchButton;
    @FindBy(css="table[class*='table table']>tbody>tr")
    public List<WebElement> tablerow;
    @FindBy(className = "login")
    public WebElement signInLink;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement emailAddress;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement mrsCheckBox;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement password;
    @FindBy(css="#newsletter")
    public WebElement newsletterBox;
    @FindBy(xpath = "//span[normalize-space()='Register']")
    public WebElement register;
    @FindBy (css = ".myaccount-link-list>li")
    public List<WebElement> myPersonalInfoButton;
    @FindBy(id = "old_passwd")
    public WebElement oldPasswd;
    @FindBy (id = "confirmation")
    public WebElement confirmNewPasswd;
    @FindBy(name = "submitIdentity")
    public WebElement saveButton;
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id="SubmitLogin")
    public WebElement signInButton;
    @FindBy(css = ".footer_links.clearfix>li")
    public List<WebElement> backToAccount;
}

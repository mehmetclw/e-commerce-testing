package com.ecommerce.elements.frontend;

import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmissionOfFormElement {
    public SubmissionOfFormElement(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    public WebElement clickOnSignIn;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement enterEmail;
    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement enterPassword;
    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement signInButton1;
    @FindBy(xpath = "//div[@id='contact-link']")
    public WebElement contactUs;
    @FindBy(xpath = "//select[@id='id_contact']")
    public WebElement chooseCustomerService;
    @FindBy(xpath = "//select[@name='id_order']")
    public WebElement chooseOrderReference;
    @FindBy(xpath = " //select[@id='7_order_products']")
    public WebElement chooseTshirt;
    @FindBy(xpath = "//textarea[@id='message']")
    public WebElement messages;
    @FindBy(xpath = "//span[text()='Send']")
    public WebElement sendButton;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement verifySuccessfullySubmit;
    @FindBy(xpath = "//input[@id='identifierId']")
    public WebElement enterEmail1;
    @FindBy(xpath = "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")
    public WebElement clickNext;
    @FindBy(xpath = "//input[@name='Passwd']")
    public WebElement enterPassword1;
    @FindBy(xpath = "//span[text()='Next']")
    public WebElement clickOnNext;
    @FindBy(xpath = "//table[@id=':22']//tr[1]")
    public WebElement getFirstEmail;

    @FindBy(xpath = "//tbody/tr[4]/td[1]/span[1]")
    public WebElement verifyEmail;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement enterEmail2;
    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement enterPassword2;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block ladda-button']")
    public WebElement clickLogIn;
    @FindBy(xpath = "//li[@id='customer_messages_notif']//a[@class='dropdown-toggle notifs']")
    public WebElement clickMessageIcon;
    @FindBy(xpath = "//a[text()='Show all messages']")
    public WebElement showMessage;
    @FindBy(xpath = "//td[normalize-space()='johndoe.info67@gmail.com']")
    public WebElement clickMessage;
    @FindBy(xpath = "//p[contains(text(),'Hello,')]")
    public WebElement verifyAdminReceivesMessage;

}

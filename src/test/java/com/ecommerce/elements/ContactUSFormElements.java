package com.ecommerce.elements;

import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUSFormElements extends Utility {
    @FindBy(xpath = "//div[@class='uploader']/span[2]")
    public WebElement chooseFile;

   @FindBy(xpath = "//p[@class='alert alert-success']")
   public WebElement verifySuccessfully;


    public ContactUSFormElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "contact-link")
    public WebElement contactUs;

    @FindBy(id = "id_contact")
    public WebElement subjectHeading;

    @FindBy(id = "email")
    public WebElement emailAddress;

    @FindBy(id = "id_order")
    public WebElement orderReference;

    @FindBy(id = "fileUpload")
    public WebElement attachFile;

    @FindBy(id = "message")
    public WebElement message;

    @FindBy(id ="submitMessage")
    public WebElement sendButton;



}
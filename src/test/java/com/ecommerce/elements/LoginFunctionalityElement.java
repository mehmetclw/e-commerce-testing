package com.ecommerce.elements;

import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFunctionalityElement {

    public LoginFunctionalityElement(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "login")
    public WebElement signInLink;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(id="SubmitLogin")
    public WebElement signInButton;

    @FindBy(className = "page-heading")
    public WebElement accountCheck;

    @FindBy(className = "info-account")
    public WebElement pCheck;











}

package com.ecommerce.elements;

import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageElements {
    // guest_email
    public CheckoutPageElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "guest_email")
    public WebElement guestPurchaseEmail;

    @FindBy(id = "firstname")
    public WebElement firstname;

    @FindBy(id = "lastname")
    public WebElement lastname;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement id_state;

    @FindBy(id = "postcode")
    public WebElement postcode;

    @FindBy(id = "id_country")
    public WebElement id_country;

    @FindBy(id = "phone_mobile")
    public WebElement phone_mobile;

    @FindBy(id = "submitGuestAccount")
    public WebElement submitGuestAccount;

    @FindBy(id = "delivery_option_281_0")
    public WebElement delivery_option_281_0;

    @FindBy(id = "cgv")
    public WebElement cgv;

    @FindBy(id = "cart_navigation")
    public WebElement cart_navigation;

}
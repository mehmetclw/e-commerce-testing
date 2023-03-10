package com.ecommerce.elements;
import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    // guest_email
    public CheckoutPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id="guest_email")
    public WebElement guestPurchaseEmail;
}

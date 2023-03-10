package com.ecommerce.elements;

import com.ecommerce.utility.Driver;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.security.auth.x500.X500Principal;

public class ReturningUserPurchaseElements {
    public ReturningUserPurchaseElements() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='header_user_info']/a")
    public WebElement clickSignIn;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement passWord;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement signInButton;

    @FindBy(name = "search_query")
    public WebElement searchBox;

    @FindBy(name = "submit_search")
    public WebElement searchButton;
    @FindBy(css = "button[name='Submit'] span")
    public WebElement addToCart;
    @FindBy(css = "a[title='Proceed to checkout'] span")
    public WebElement proceedToCheckout;
    @FindBy(xpath = "//span[@class='heading-counter']")
    public WebElement shoppingCartSummary;
    @FindBy(xpath = "//span[@id='summary_products_quantity']")
    public WebElement summaryProductQuantity;

    @FindBy(css = "#total_price_without_tax")
    public WebElement totalCart;
    @FindBy(css = "a[class='button btn btn-default standard-checkout button-medium'] span")
    public WebElement proceedToCheckout1;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2']")
    public WebElement userStreetAddress;
    @FindBy(css = "ul[id='address_delivery'] li[class='address_city address_state_name address_postcode']")
    public WebElement userCityStateAddress;
    @FindBy(css = "button[name='processAddress'] span")
    public WebElement getProceedToCheckout2;
    @FindBy(xpath = "//input[@id='cgv']")
    public WebElement checkAgreeTerms;
    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    public WebElement getProceedToCheckout3;
    @FindBy(xpath = "//a[@title='Pay by check.']")
    public WebElement payByCheck;
    @FindBy(xpath = "//span[normalize-space()='I confirm my order']")
    public WebElement confirmMyOrderButton;
    @FindBy(css =".page-heading")
    public WebElement OrderHistory;
    @FindBy(xpath = "//a[normalize-space()='View your order history']")
    public WebElement viewOrderHistoryButton;
    @FindBy(xpath = "//tr[contains(@class,'first_item')]//span[contains(text(),'Details')]")
    public WebElement orderDetailsButton;
    @FindBy(xpath = "//*[@id='product_list']/child::li[1]")
    public WebElement imageComponent;




}

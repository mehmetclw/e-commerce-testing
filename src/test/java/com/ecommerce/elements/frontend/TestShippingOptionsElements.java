package com.ecommerce.elements.frontend;

import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.List;

public class TestShippingOptionsElements {
    public TestShippingOptionsElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriver driver;
    @FindBy(xpath = "//div[@class='header_user_info']/a")
    public WebElement clickSignIn;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement passWord;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement signInButton;
    @FindBy(xpath = "//a[@title='Women']")
    public WebElement clickWomenLink;

    @FindBy(xpath = "//img[@src='https://ecommerce.yosemiteint.com/prestashop/img/p/1/1-home_default.jpg']")
    public WebElement clickTshirtLink;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    public WebElement chooseNumberOfTshirt;

    @FindBy(xpath = "//select[@id='group_1']")
    public WebElement clickChooseSize;

    @FindBy(xpath = "//select[@id='group_1']/option[1]")
    public WebElement chooseSize_S;

    @FindBy(xpath = "//a[@id='color_13']")
    public WebElement chooseColor;

    @FindBy(xpath = "//span[text()='Add to cart']")
    public WebElement addToCart;
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")

    public WebElement proceedToChckout;
    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")

    public WebElement proceedToCheckout1;
    @FindBy(xpath = " //strong[text()='Fast Trans']")
    public WebElement fastTransOption;
    @FindBy(xpath = "//strong[text()='My carrier']")
    public WebElement myCarrierOption;
    @FindBy(xpath = "//p[@class='carrier_title']")
    public WebElement carrierOption;
    @FindBy(xpath = "//input[@id='delivery_option_199_0']")
    public WebElement deliveryOption1;
    @FindBy(xpath = "//input[@id='delivery_option_199_1']")
    public WebElement deliveryOption2;
    @FindBy(xpath = "//input[@id='cgv']")
    public WebElement agreeTermsSelect;
    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    public WebElement getProceedToCheckout2;
    @FindBy(xpath = "//div[normalize-space()='$7.00']")
    public WebElement shippingCost;
    @FindBy(xpath = "//td[@id='total_shipping']")
    public WebElement totalShipping;
    @FindBy(xpath = "//td[@id='total_product']")
    public WebElement totalProducts;
    @FindBy(xpath = "//span[@id='total_price']")
    public WebElement Total;


}

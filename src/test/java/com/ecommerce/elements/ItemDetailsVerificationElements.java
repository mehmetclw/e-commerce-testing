package com.ecommerce.elements;


import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ItemDetailsVerificationElements {
    //This is going to initialize the page objects
    public ItemDetailsVerificationElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "login")
    public WebElement signInLink;
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "passwd")
    public WebElement password;
    @FindBy(id = "SubmitLogin")
    public WebElement signInButton;
    @FindBy(linkText = "Women")
    public WebElement womenLink;
    @FindBy(css = "h5[itemprop=name]>a.product-name")
    public  List<WebElement> pageProducts;
    @FindBy(xpath = "//h1[text()='Faded Short Sleeves T-shirt']")
    public  WebElement actualItemTitle;
    @FindBy(id = "short_description_content")
    public  WebElement actualItemDescription;
    @FindBy(id = "our_price_display")
    public  WebElement actualItemSale;
    @FindBy(name="Submit")
    public   WebElement addToCart;
    @FindBy(css = "div[class*='layer_cart_product col']>span.title")
    public   WebElement checkAddMessage;
    @FindBy(linkText = "Quick view")
    public WebElement quickview;
    @FindBy(css = ".fancybox-iframe")
    public  WebElement iframeLocator;
    @FindBy(css = "div[class*='pb-center-column']>h1")
    public  WebElement actualItemWindowTitle;
    @FindBy(css="#cart_title")
    public  WebElement checkWindowAddMessage;

}

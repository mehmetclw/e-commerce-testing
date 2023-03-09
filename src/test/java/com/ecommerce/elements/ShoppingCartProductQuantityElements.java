package com.ecommerce.elements;

import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartProductQuantityElements {
    public ShoppingCartProductQuantityElements(){ PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "(//a[@title='Faded Short Sleeves T-shirt'][normalize-space()='Faded Short Sleeves T-shirt'])[1]")
    public WebElement clickAnyProduct;

    @FindBy(xpath="(//span[contains(text(),'Add to cart')])[4]" )
    public WebElement addProductToCart;
    @FindBy(xpath = "(//span[normalize-space()='Proceed to checkout'])[1]")
    public WebElement checkOut;
    @FindBy(xpath="//a[@id='cart_quantity_up_8_51_0_0']//span" )
    public WebElement increaseQuantityOfProduct;
    @FindBy (xpath ="(//span[@id='total_price_without_tax'])[1]" )
    public WebElement afterIncreaseProductPrice;
    @FindBy(xpath= "//a[@id='cart_quantity_down_8_51_0_0']//i[@class='icon-minus']")
    public WebElement decreaseQuantityOfProduct;
    @FindBy(xpath="//span[@id='total_price_without_tax']" )
    public WebElement afterDecreaseProductPrice;
}



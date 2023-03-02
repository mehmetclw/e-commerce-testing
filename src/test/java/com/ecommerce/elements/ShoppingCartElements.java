package com.ecommerce.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
    public class ShoppingCartElements {
        WebDriver driver;
        //This is going to initialize the page objects
        public ShoppingCartElements(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

        @FindBy(xpath = "//div[@class='header_user_info']/a")
        public WebElement clickSignIn;

        @FindBy(xpath = "//input[@id='email']")
        public WebElement emailAdress;

        @FindBy(xpath = "//input[@id='passwd']")
        public WebElement password;

        @FindBy(xpath = "//span[normalize-space()='Sign in']")
        public WebElement signInButton;


        @FindBy(xpath = "//a[@title='Women']")
        public WebElement clickWomenLink;

        @FindBy(xpath = "//img[@src='https://ecommerce.yosemiteint.com/prestashop/img/p/1/1-home_default.jpg']")
        public WebElement clickTshirtLink;

        @FindBy (xpath = "//input[@id='quantity_wanted']")
        public WebElement chooseNumberOfTshirt;

        @FindBy(xpath = "//select[@id='group_1']")
        public WebElement clickChooseSize;

        @FindBy(xpath = "//select[@id='group_1']/option[1]")
        public WebElement chooseSize_S;

        @FindBy(xpath = "//a[@id='color_13']")
        public WebElement chooseColor;

        @FindBy(xpath = "//span[text()='Add to cart']")
        public WebElement addToCart;

        @FindBy(xpath = "//h5[@itemprop='name']/a")
        public List<WebElement> clickDress;

        @FindBy(xpath = "//span[text()='Add to cart']")
        public WebElement addToCart1;

        @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
        public WebElement proceedToCheckOut;

        @FindBy(xpath = "//i[@class='icon-trash']")
        public List<WebElement> clickDeleteButton;

        @FindBy(xpath = "//h1[@id='cart_title']")
        public WebElement cartTitleCheck;

        @FindBy(xpath = "//span[@id='total_price_without_tax']")
        public WebElement totalCalculation;


    }




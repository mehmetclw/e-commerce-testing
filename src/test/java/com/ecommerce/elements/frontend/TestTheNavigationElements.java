package com.ecommerce.elements.frontend;

import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestTheNavigationElements {
    //This is going to initialize the page objects
    public TestTheNavigationElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(xpath = "(//a[@title='Women'])[1]")
        public WebElement womenTab;

        @FindBy(xpath = "//span[@class='cat-name']")
        public WebElement womenPageHeader;

        @FindBy(xpath = "(//a[@title='Women'])[1]")
        public WebElement womenTab2;

        @FindBy(xpath = "(//a[@title='T-shirts'][normalize-space()='T-shirts'])[1]")
        public WebElement tShirtLink;

        public @FindBy(xpath = "//h1[@class='page-heading product-listing']")
        WebElement tShirtPageHeader;

        @FindBy(xpath = "(//a[@title='Women'])[1]")
        public WebElement womenTab3;

        @FindBy(xpath = "(//a[@title='Blouses'])[1]")
        public WebElement blouseLink;

        @FindBy(xpath = "//span[@class='cat-name']")
        public WebElement blouseLinkPageHeader;

        @FindBy(xpath = "(//a[@title='Women'])[1]")
        public WebElement womenTab4;

        @FindBy(xpath = "(//a[@title='Casual Dresses'])[1]")
        public WebElement casualDress;

        @FindBy(xpath = "(//span[@class='cat-name'])[1]")
        public WebElement casualDressPageHeader;

        @FindBy(xpath = "(//a[@title='Women'])[1]")
        public WebElement womenTab5;

        @FindBy(xpath = "(//a[@title='Evening Dresses'])[1]")
        public WebElement eveningDress;

        @FindBy(xpath = "(//span[@class='cat-name'])[1]")
        public WebElement eveningDressPageHeader;

        @FindBy(xpath = "(//a[@title='Women'])[1]")
        public WebElement womenTab6;

        @FindBy(xpath = "(//a[@title='Summer Dresses'])[1]")
        public WebElement summerDress;

        @FindBy(xpath = "(//span[@class='cat-name'])[1]")
        public WebElement summerDressPageHeader;

        @FindBy(xpath = "(//a[@title='Dresses'])[2]")
        public WebElement dressesBar;

        @FindBy(xpath = "(//span[@class='cat-name'])[1]")
        public WebElement dressesBarPageHeader;

        @FindBy(xpath = "(//a[@title='Dresses'])[2]")
        public WebElement dressesBar1;

        @FindBy(xpath = "(//a[@title='Casual Dresses'][normalize-space()='Casual Dresses'])[2]")
        public WebElement casualDressLink;

        @FindBy(xpath = "(//span[@class='cat-name'])[1]")
        public WebElement casualDressLinkPageHeader;

        @FindBy(xpath = "(//a[@title='Dresses'])[2]")
        public WebElement dressesBar2;

        @FindBy(xpath = "(//a[@title='Evening Dresses'])[2]")
        public WebElement eveningDressLink;

        @FindBy(xpath = "(//span[@class='cat-name'])[1]")
        public WebElement eveningDressLinkPageHeadr;
        @FindBy(xpath = "(//a[@title='Dresses'])[2]")
        public WebElement dressesBar3;

        @FindBy(xpath = "(//a[@title='Summer Dresses'][normalize-space()='Summer Dresses'])[2]")
        public WebElement summerDressLink;

        @FindBy(xpath = "//span[@class='cat-name']")
        public WebElement summerDressLinkPageHeader;

        @FindBy(xpath = "(//a[@title='T-shirts'])[2]")
        public WebElement tshirtsBar;

        @FindBy(xpath = "(//span[@class='cat-name'])[1]")
        public WebElement tshirtsBarPageHeader;


    }



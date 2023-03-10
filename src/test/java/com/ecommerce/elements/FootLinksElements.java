package com.ecommerce.elements;

import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FootLinksElements {
    public FootLinksElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//footer//a[contains(@title,'')][normalize-space()='Women']")
    public WebElement womenLink;
    @FindBy(xpath = "//span[@class='cat-name']")
    public WebElement womenLinkPageHeader;

    @FindBy(xpath = "//section[@id='block_various_links_footer']//a[contains(@title,'Specials')]")
    public WebElement specialLink;

    @FindBy (xpath ="(//h1[normalize-space()='Price drop'])[1]")
    public WebElement specialLinkPageHeader;

    @FindBy(xpath = "//section[@id='block_various_links_footer']//a[contains(@title,'New products')]")
    public WebElement newProductsLink;

    @FindBy(xpath ="//a[normalize-space()='Best sellers']" )
    public WebElement bestSellersLink;

    @FindBy(xpath = "(//a[@title='Our stores'])[5]")
    public WebElement ourStores;

    @FindBy(xpath = "(//a[@title='Contact us'])[2]")
    public WebElement contactUs;

    @FindBy (xpath ="//a[@title='Terms and conditions of use']" )
    public WebElement termsAndConditions;

    @FindBy(xpath = "//a[@title='About us']")
    public WebElement aboutUs;

    @FindBy(xpath ="//a[@title='Sitemap']" )
    public WebElement sitemap;

    @FindBy(xpath = "//a[@title='My orders']" )
    public WebElement myOrders;

    @FindBy(xpath = "(//a[@title='My credit slips'])[1]")
    public WebElement myCreditSlips;

    @FindBy(xpath = "//a[@title='My addresses']")
    public WebElement myAddresses;

    @FindBy(xpath = "//a[@title='Manage my personal information']")
    public WebElement myPersonalInfo;



}
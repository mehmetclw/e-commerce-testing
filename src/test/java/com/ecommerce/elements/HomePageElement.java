package com.ecommerce.elements;

import com.ecommerce.utility.Driver;
import org.bouncycastle.est.LimitedSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElement {
    public HomePageElement() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//form/button[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "(//img[@class='item-img '])[7]")
    public WebElement image;

    @FindBy(xpath = "//a[@title='Manage my customer account']")
    public WebElement myAccountLink;

    @FindBy(xpath = "//ul[@id='blocknewproducts']/li")
    public List<WebElement> homePageProducts;

}

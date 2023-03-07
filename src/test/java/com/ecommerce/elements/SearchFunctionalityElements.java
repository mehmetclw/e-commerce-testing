package com.ecommerce.elements;

import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchFunctionalityElements {
    //This is going to initialize the page objects
    public SearchFunctionalityElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name = "search_query")
    public WebElement searchBox;
    @FindBy(name="submit_search")
    public WebElement searchButton;
    @FindBy(xpath = "//p[@class='alert alert-warning']")
    public WebElement errorMessage;
    @FindBy(css = "select[id='selectProductSort']")
    public WebElement sortOption;
    @FindBy(xpath = "//ul[@class='product_list grid row']")
    public List<WebElement> searchResults;

}

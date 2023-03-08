package com.ecommerce.tests;

import com.ecommerce.pages.SearchFunctionalityPages;
import com.ecommerce.pages.UserRegistrationPages;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Database;
import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchFunctionalityTest extends TestBase{
    public String url = ConfigReader.getProperty("url");

    @Test(groups = {"smoke", "regression"},
    description = "Search",priority = 1)
    public void validSearching() {
        /**
         * Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
         * Verify you are in home page / Expected title="My Store"
         * Click on search button type "Dress"
         * click search
         * verify the search page id displayed
         * check all the expected result to be Dress items
         *product name have Dress
         * */
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getSfp().validSearching();
    }

    @Test(groups = "regression",
    description = "search results",priority = 2)
    public void sortTheResults() {

        /******** Sort the search results by price (lowest to highest)
         * go to sort option
         * select price low to hight
         * check the prices result is sorted
         */
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getSfp().sortTheResults();
    }

    @Test(groups = {"regression"},
    description = "invalid Search",priority = 3)
    public void invalidSearching() {
        /***********************invalidSearching
         * * Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
         * to search button
         * enter invalid search "xzy"
         *Click on the search button
         *Verify that error message is displayed
         */
        System.out.println("url = " + url);
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getSfp().invalidSearching();
    }
}
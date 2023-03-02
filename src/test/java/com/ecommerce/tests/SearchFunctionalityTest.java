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

public class SearchFunctionalityTest {
    WebDriver driver;
    SearchFunctionalityPages sfp;
    public String url = ConfigReader.getProperty("url");

    @BeforeClass
    public void browserSetup() {
        driver = WebDriverManager.chromedriver().create();
        //driver = WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
         sfp = new SearchFunctionalityPages(driver);
    }



    @Test
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
        sfp.validSearching();
    }
    @Test
    public void sortTheResults() {

        /******** Sort the search results by price (lowest to highest)
         * go to sort option
         * select price low to hight
         * check the prices result is sorted
         */
        sfp.sortTheResults();
    }
@Test
    public void invalidSearching() {
        /***********************invalidSearching
         * scrollUp in to search box
         * go back to search box
         *Clear the search box and enter an invalid search term"XYZ"
         *Click on the search button
         *Verify that error message is displayed
         */
        sfp.invalidSearching();
    }


}
package com.ecommerce.pages;

import com.ecommerce.elements.SearchFunctionalityElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchFunctionalityPages {
    WebDriver driver;
    SearchFunctionalityElements sfe;
    public SearchFunctionalityPages (WebDriver driver) {
        this.driver=driver;
    }
    public String email = ConfigReader.getProperty("email");
    public String password = "";

    public void validSearching(){
        /**
         * Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
         * Verify you are in home page / Expected title="My Store"
         * Click on search button type "Dress"
         * click search
         * verify the search page id displayed
         * check all the expected result to be Dress items
         *product name have Dress
         * */
        sfe = new SearchFunctionalityElements(driver);
        //* Verify you are in home page / Expected title="My Store"
        String expectedPageTitle = "My Store";
        // Get the title of the web page and compare to expected title
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, expectedPageTitle, "Page title not match");
        System.out.println("The user in the home page");
        //Go to search button and Enter "Dress" and click search
        sfe.searchBox.click();
        sfe.searchBox.sendKeys("Dress");
        sfe.searchButton.click();
        //verify the search page id displayed
        String expectedSearchPageTitle = "Search - My Store";
        String searchPageTitle = driver.getTitle();
        Assert.assertEquals(searchPageTitle, expectedSearchPageTitle, "Search page not displayed");
        System.out.println("the user is in searching page ");
        Utility.waits(3);
        scrollUp(driver);
        // Verify that relevant search results are displayed
        List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@class='product_list grid row']"));
        for (WebElement searchResult : searchResults) {
            String productTitle = searchResult.findElement(By.cssSelector("h5>a")).getText();
            if (!productTitle.contains("Dress")) {
                System.out.println("Error: Invalid search result - " + productTitle);
            } else {
                System.out.println("Relevant search result ");
            }
        }
    }
    public void sortTheResults() {
        /** Sort the search results by price (lowest to highest)
         * go to sort option
         * select price low to hight
         * check the prices result is sorted
         */

        sfe = new SearchFunctionalityElements(driver);
        sfe.searchBox.click();
        sfe.searchBox.sendKeys("Dress");
        sfe.searchButton.click();
        sfe.sortOption.click();
        Select select= new Select(sfe.sortOption);
        select.selectByValue("price:asc");
        // Verify that search results are sorted by price correctly
        List<WebElement> productPrices = driver.findElements(By.xpath("//ul[@id=product_list]"));
        List<Float> prices = new ArrayList<Float>();

        for (WebElement productPrice : productPrices) {
            String priceText = productPrice.getText().replace("$", "");
            prices.add(Float.valueOf(priceText));}
            List<Float> sortedPrices = new ArrayList<Float>(prices);
             Collections.sort(sortedPrices);

            if (!prices.equals(sortedPrices)) {
                System.out.println("Error: Search results are not sorted by price correctly");
            }
            else System.out.println("Prices are sorting form lowest to highest");

        }
    public void invalidSearching() {
        /***********************invalid Searching
         * * Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
         * go to search button
         * enter invalid search "xzy"
         *Clear the search box and enter an invalid search term
         *Click on the search button again
         *Verify that error message is displayed
          */
        sfe = new SearchFunctionalityElements(driver);
        //Go to search button and Enter "xyz" and click search
        sfe.searchBox.click();
        sfe.searchBox.sendKeys("xyz");
        sfe.searchButton.click();
        String errorMessageDisplayed="No results were found for your search \"xyz\"";
        Assert.assertEquals(sfe.errorMessage.getText(),errorMessageDisplayed,"Error message not displayed");


    }
    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
}

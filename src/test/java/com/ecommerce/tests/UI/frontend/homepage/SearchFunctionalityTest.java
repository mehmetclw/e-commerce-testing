package com.ecommerce.tests.UI.frontend.homepage;

import com.ecommerce.tests.TestBase.TestBase;
import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.Test;

public class SearchFunctionalityTest extends TestBase {
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
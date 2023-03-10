package com.ecommerce.tests.UI.frontend;

import com.ecommerce.tests.TestBase.TestBase;
import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.Test;

public class TestTheNavigationTest extends TestBase {

    /* Description:
Test the navigation
URL: https://ecommerce.yosemiteint.com/prestashop/index.php

Acceptance Criteria:
a . Check if all the links in the navigation bar work correctly.
b. Verify that the user is redirected to the correct page when clicking on a link.

     */
    //TODO  CTRL + SHIFT + L  => ORGANIZE THE CODES => WINDOWS
    //TODO  COMMAND + OPTION + L  => ORGANIZE THE CODES => MAC

    /**
     * Happy path story for Test Navigation;
     * 1- Go to the website
     * 2- Go to the Women bar
     * a- Click Women bar
     * b- Verify that is correct page with header
     * c- Hover over to  Women bar
     * d- Click T-Shirts link
     * e- Verify that is correct page with header
     * f-Hover over Women bar
     * g-Click the Blouses link
     * h-Verify that is correct with header
     * 3- Go to the Dresses bar
     * a- Click the Dresses bar
     * b- Verify that is correct page with header
     * c- Hover over the dress bar
     * d- Click on Casual Dresses
     * e- Verify that is correct page with header
     * f- Hover over Dresses bar
     * g- Click on Evening Dress
     * h- Verify that is correct page with header
     * i- Hover over  dress bar
     * j- Click on the Summer Dresses
     * k- Verify that is correct page with header
     * 4- Go to the T-Shirts Tab
     * a- Click on the T-Shirts tab
     * b- Verify that is correct page with header
     **/
    public String url = ConfigReader.getProperty("url");

    @Test(groups = "regression",
    description = "Click the Women link section")
    public void checkingWomenBar() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getTnp().checkingWomenBar();
    }

    @Test(groups = "regression",
    description = "Verify the Dress Bar")
    public void checkingDressBar() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getTnp().checkingDressBar();
    }

    @Test(groups = {"smoke","regression","sanity"},
    description = "Check Tshirts section")
    public void checkingTShirtsBar() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getTnp().checkingTShirtsBar();
    }
}
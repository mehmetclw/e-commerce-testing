package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FootlinksTest extends TestBase {

    SoftAssert sf = new SoftAssert();
    public String url = ConfigReader.getProperty("url");

    @Test(groups = {"smoke", "regression"},
            description = "EC-54 UI | Test the Footer Links under Categories")
    public void checkCategoriesLink() {

        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getFlp().checkCategoriesLink();

    }

    @Test(groups = {"smoke", "regression"},
            description = "EC-83 UI | Test Footer Links under Information")
    public void checkInformationLinks() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getFlp().checkInformationLinks();

    }

    @Test(groups = {"smoke", "regression"},
            description = "EC-84 UI | Test Footer Links under My Account")
    public void myAccountLinks() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getFlp().myAccountLinks();
    }
}
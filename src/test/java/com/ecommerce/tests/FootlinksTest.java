package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.ecommerce.utility.Utility.waits;

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
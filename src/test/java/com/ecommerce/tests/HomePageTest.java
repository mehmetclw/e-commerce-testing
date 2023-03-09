package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends TestBase {

    SoftAssert sf = new SoftAssert();
    String url = ConfigReader.getProperty("url");

    @Test(groups = {"regression"})
    public void verifyHomePageTest() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getHPage().verifyHomePage();
    }

    @Test(groups = {"regression"})
    public void verifyHomePageTitle() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        //Verify Title
        String expectedTitle = "My Store";
        String actualTitle = getAppLibrary().getFlowsLibrary().getCurrentPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title didn't match");
    }

    @Test(groups = {"regression"})
    public void checkHomePageProducts() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getHPage().checkHomePageProductsPage();
    }
}

package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginFunctionalityTest extends TestBase {


    public String url = ConfigReader.getProperty("url");

    @Test(groups = {"smoke", "regression"},
    description = "EC-2 UI | Test the login functionality")
    public void loginFunctionalityTest()  {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getLoginFunctionalityPage().loginFunctionalityTest();
    }
}

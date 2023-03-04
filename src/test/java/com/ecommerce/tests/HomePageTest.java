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

public class HomePageTest extends TestBase{

    SoftAssert sf = new SoftAssert();
    String url = ConfigReader.getProperty("url");

    @Test(groups = {"regression"})
    public void verifyHomePage(){
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
       //Verify search button is clickable
        WebElement searchButton= Driver.getDriver().findElement(By.xpath("//form/button[@type='submit']"));
        boolean check=Utility.isClickable(Driver.getDriver(),searchButton,10);
        Assert.assertTrue(check);

        //Scrolling to a specific element and click on it.
        WebElement image=Driver.getDriver().findElement(By.xpath("(//img[@class='item-img '])[7]"));
        //Utility.scrollTo(driver,image);
        Utility.scrollToCenter(Driver.getDriver(),image);
        Utility.waits(4);
        WebElement myAccountLink= Driver.getDriver().findElement(By.xpath("//a[@title='Manage my customer account']"));
        Utility.scrollTo(Driver.getDriver(),myAccountLink);
        Utility.waits(4);
        myAccountLink.click();

    }
    @Test(groups = {"regression"})
    public void verifyHomePageTitle(){
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        //Verify Title
        String expectedTitle="My Store";
        String actualTitle=getAppLibrary().getFlowsLibrary().getCurrentPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title didn't match");
    }

    @Test
    public  void checkHomePageProducts(){
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        List<WebElement> homePageProducts= Driver.getDriver().findElements(By.xpath("//ul[@id='blocknewproducts']/li"));
        Utility.scrollToCenter(Driver.getDriver(),homePageProducts.get(0));
       // String[] expectedPrice={"$50.99","$26.00","$30.00","$27.00"};
        //Try to verify each price is as expected after hoverover
        for (WebElement product:homePageProducts){
            Utility.hoverOver(Driver.getDriver(),product,1);
        }
    }
}

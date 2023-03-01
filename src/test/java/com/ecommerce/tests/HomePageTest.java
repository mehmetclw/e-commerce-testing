package com.ecommerce.tests;

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

public class HomePageTest {

    WebDriver driver;
    SoftAssert sf = new SoftAssert();

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://ecommerce.yosemiteint.com/prestashop/index.php");
    }

    @Test(groups = {"regression"})
    public void verifyHomePage(){
       //Verify search button is clickable
        WebElement searchButton=driver.findElement(By.xpath("//form/button[@type='submit']"));
        boolean check=Utility.isClickable(driver,searchButton,10);
        Assert.assertTrue(check);

        //Scrolling to a specific element and click on it.
        WebElement image=driver.findElement(By.xpath("(//img[@class='item-img '])[7]"));
        //Utility.scrollTo(driver,image);
        Utility.scrollToCenter(driver,image);
        Utility.waits(4);
        WebElement myAccountLink= driver.findElement(By.xpath("//a[@title='Manage my customer account']"));
        Utility.scrollTo(driver,myAccountLink);
        Utility.waits(4);
        myAccountLink.click();

    }
    @Test(groups = {"regression"})
    public void verifyHomePageTitle(){
        //Verify Title
        String expectedTitle="My Store";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title didn't match");
    }

    @Test
    public  void checkHomePageProducts(){
        List<WebElement> homePageProducts= driver.findElements(By.xpath("//ul[@id='blocknewproducts']/li"));
        Utility.scrollToCenter(driver,homePageProducts.get(0));
       // String[] expectedPrice={"$50.99","$26.00","$30.00","$27.00"};
        //Try to verify each price is as expected after hoverover
        for (WebElement product:homePageProducts){
            Utility.hoverOver(driver,product,1);
        }
    }
}

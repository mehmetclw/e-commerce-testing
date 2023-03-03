package com.ecommerce.tests;

import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestTheNavigation {
    /* Description:
Test the navigation
URL: https://ecommerce.yosemiteint.com/prestashop/index.php

Acceptance Criteria:
a. Check if all the links in the navigation bar work correctly.
b. Verify that the user is redirected to the correct page when clicking on a link.

     */

    /**
     * Happy path story for Test Navigation;
     * 1- Go to the website
     * 2- Go to the Women bar
     *      a- Click Women bar
     *      b- Verify that is correct page with header
     *      c- Hover over to  Women bar
     *      d- Click T-Shirts link
     *      e- Verify that is correct page with header
     *      f-Hover over Women bar
     *      g-Click the Blouses link
     *      h-Verify that is correct with header
     * 3- Go to the Dresses bar
     *      a- Click the Dresses bar
     *      b- Verify that is correct page with header
     *      c- Hover over the dress bar
     *      d- Click on Casual Dresses
     *      e- Verify that is correct page with header
     *      f- Hover over Dresses bar
     *      g- Click on Evening Dress
     *      h- Verify that is correct page with header
     *      i- Hover over  dress bar
     *      j- Click on the Summer Dresses
     *      k- Verify that is correct page with header 
     * 4- Go to the T-Shirts Tab
     *      a- Click on the T-Shirts tab
     *      b- Verify that is correct page with header
     **/

    WebDriver driver;

    @BeforeMethod

    public void browserSetup() {
        driver = WebDriverManager.chromedriver().create();
        //driver = WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ecommerce.yosemiteint.com/prestashop/index.php");
    }

    @Test
    public void checkingWomenBar() {
        // Going and CLicking to the Women Tab
        WebElement womenTab = driver.findElement(By.xpath("(//a[@title='Women'])[1]"));
        womenTab.click();
        // Verifying the page
        WebElement womenPageHeader = driver.findElement(By.xpath("//span[@class='cat-name']"));
        Assert.assertTrue(womenPageHeader.isDisplayed());
        Utility.waits(1);
        // Hover over Women tab again for TSHirt link
        WebElement womenTab2 = driver.findElement(By.xpath("(//a[@title='Women'])[1]"));
        // Hover over to TShirt link
        Utility.hoverOver(driver,womenTab2,2);
        Utility.waits(1);
        WebElement tShirtLink = driver.findElement(By.xpath("(//a[@title='T-shirts'][normalize-space()='T-shirts'])[1]"));
        tShirtLink.click();
        Utility.waits(2);
        // Verifying the TShirt page
        WebElement tShirtPageHeader = driver.findElement(By.xpath("//h1[@class='page-heading product-listing']"));
        Assert.assertTrue(tShirtPageHeader.isDisplayed());
        //Hover Over Women tab for Blouse link
        WebElement womenTab3 = driver.findElement(By.xpath("(//a[@title='Women'])[1]"));
        Utility.hoverOver(driver,womenTab3,2);
        // Go and click blouse link
        WebElement blouseLink = driver.findElement(By.xpath("(//a[@title='Blouses'])[1]"));
        blouseLink.click();
        Utility.waits(1);
        // Verify the blouse link page
        WebElement blouseLinkPageHeader = driver.findElement(By.xpath("//span[@class='cat-name']"));
        Assert.assertTrue(blouseLinkPageHeader.isDisplayed());
        // Hover over Women Tab and Click Casual Dress
        WebElement womenTab4 = driver.findElement(By.xpath("(//a[@title='Women'])[1]"));
        Utility.hoverOver(driver,womenTab4,1);
        WebElement casualDress=driver.findElement(By.xpath("(//a[@title='Casual Dresses'])[1]"));
        casualDress.click();
        // Verify the page
        WebElement casualDressPageHeader= driver.findElement(By.xpath("(//span[@class='cat-name'])[1]")) ;
        Assert.assertTrue(casualDressPageHeader.isDisplayed());
        // Hover over Women Tab and Click Evening Dress
        WebElement womenTab5 = driver.findElement(By.xpath("(//a[@title='Women'])[1]"));
        Utility.hoverOver(driver,womenTab5,1);
        WebElement eveningDress= driver.findElement(By.xpath("(//a[@title='Evening Dresses'])[1]"));
        eveningDress.click();
        // Verify the page
        WebElement eveningDressPageHeader= driver.findElement(By.xpath("(//span[@class='cat-name'])[1]"));
        Assert.assertTrue(eveningDressPageHeader.isDisplayed());
        // Hover over Women Tab and Click Summer Dress
        WebElement womenTab6 = driver.findElement(By.xpath("(//a[@title='Women'])[1]"));
        Utility.hoverOver(driver,womenTab6,1);
        WebElement summerDress= driver.findElement(By.xpath("(//a[@title='Summer Dresses'])[1]"));
        summerDress.click();
        // Verify the page
        WebElement summerDressPageHeader= driver.findElement(By.xpath("(//span[@class='cat-name'])[1]"));
        Assert.assertTrue(summerDressPageHeader.isDisplayed());
    }

    @Test
    public void checkingDressBar() {
        // Go to Dresses Bar click and verify the page
        WebElement dressesBar = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
        dressesBar.click();
        Utility.waits(1);
        WebElement dressesBarPageHeader = driver.findElement(By.xpath("(//span[@class='cat-name'])[1]"));
        Assert.assertTrue(dressesBarPageHeader.isDisplayed());
        // Hover over 'Dresses' bar and click 'Casual Dresses'
        Utility.waits(1);
        WebElement dressesBar1 = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
        Utility.hoverOver(driver,dressesBar1,2);
        WebElement casualDressLink = driver.findElement(By.xpath("(//a[@title='Casual Dresses'][normalize-space()='Casual Dresses'])[2]"));
        casualDressLink.click();
        Utility.waits(2);
        // verify the casual dress link page
        WebElement casualDressLinkPageHeader = driver.findElement(By.xpath("(//span[@class='cat-name'])[1]"));
        Assert.assertTrue(casualDressLinkPageHeader.isDisplayed());
        // Go to the home page hover over 'Dresses' bar and click 'Evening Dresses'
        Utility.waits(1);
        WebElement dressesBar2 = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
        Utility.hoverOver(driver,dressesBar2,2);
        WebElement eveningDressLink = driver.findElement(By.xpath("(//a[@title='Evening Dresses'])[2]"));
        eveningDressLink.click();
        Utility.waits(2);
        // verify the Evening dress link page
        WebElement eveningDressLinkPageHeadr = driver.findElement(By.xpath("(//span[@class='cat-name'])[1]"));
        Assert.assertTrue(eveningDressLinkPageHeadr.isDisplayed());
        // Hover over 'Dresses' bar and click 'Summer Dresses'
        Utility.waits(1);
        WebElement dressesBar3 = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
        Utility.hoverOver(driver,dressesBar3,2);
        WebElement summerDressLink = driver.findElement(By.xpath("(//a[@title='Summer Dresses'][normalize-space()='Summer Dresses'])[2]"));
        summerDressLink.click();
        Utility.waits(2);
        // verify the Evening dress link page
        WebElement summerDressLinkPageHeader = driver.findElement(By.xpath("//span[@class='cat-name']"));
        Assert.assertTrue(summerDressLinkPageHeader.isDisplayed());
    }

    @Test
    public void checkingTShirtsBar() {
        //Go and Click to the T-Shirts Bar
        WebElement tshirtsBar = driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]"));
        tshirtsBar.click();
        // verify the page
        WebElement tshirtsBarPageHeader = driver.findElement(By.xpath("(//span[@class='cat-name'])[1]"));
        Assert.assertTrue(tshirtsBarPageHeader.isDisplayed());
        Utility.waits(2);
    }
}
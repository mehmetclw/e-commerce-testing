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
     *      c- Go back home page
     *      d- Hover over to  Women bar
     *      e- Click T-Shirts link
     *      f-Verify that is correct page with header
     *      g- Go back home page,
     *      h-Hover over Women bar
     *      i- Click the Blouses link
     *      j-Verify that is correct with header
     * 3- Go to the Dresses bar
     *      a- Click the Dresses bar
     *      b- Verify that is correct page with header
     *      c- Go back home page
     *      d- Hover over the dress bar
     *      e- Click on Casual Dresses
     *      f- Verify that is correct page with header
     *      g- Go back home page
     *      h- Hover over Dresses bar
     *      i-Go to the Evening Dresses
     *      j- Click on Evening Dress
     *      k- Verify that is correct page when click
     *      l- Go back home page
     *      n- Hover over  dress bar
     *      o- Click on the Summer Dresses
     *      p- Verify that is correct page with header
     * 4- Go to the T-Shirts Tab
     *      a- Click on the T-Shirts tab
     *      b- Verify that is correct page when click
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
        WebElement womenTab = driver.findElement(By.xpath("//*[@class='sf-with-ul'][@title='Women']"));
        womenTab.click();
        // Verifying the page
        WebElement womenPageHeader = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[1]"));
        Assert.assertTrue(womenPageHeader.isDisplayed());
        Utility.waits(1);
        //Going to the home page
        WebElement goToHomePage = driver.findElement(By.xpath("//*[@id='columns']/div[1]/a/i"));
        Utility.waits(1);
        // Women tab again for TSHirt link
        WebElement womenTab2 = driver.findElement(By.xpath("//*[@class='sf-with-ul'][@title='Women']"));
        // Hover over to TShirt link
        Actions actions = new Actions(driver);
        actions.moveToElement(womenTab2).perform();
        Utility.waits(1);
        WebElement tShirtLink = driver.findElement(By.xpath("(//a[@title='T-shirts'][normalize-space()='T-shirts'])[1]"));
        tShirtLink.click();
        Utility.waits(2);
        // Verifying the TShirt page
        WebElement tShirtPageHeader = driver.findElement(By.xpath("//h1[@class='page-heading product-listing']"));
        Assert.assertTrue(tShirtPageHeader.isDisplayed());
        // Going to home page
        WebElement goToHomePage2 = driver.findElement(By.xpath("//*[@id='columns']/div[1]/a/i"));
        // Go and Hover Over Women tab for Blouse link
        WebElement womenTab3 = driver.findElement(By.xpath("//*[@class='sf-with-ul'][@title='Women']"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(womenTab3).perform();
        // Go and click blouse link
        WebElement blouseLink = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a"));
        blouseLink.click();
        Utility.waits(1);
        // Verify the blouse link page
        WebElement blouseLinkPageHeader = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[1]"));
        Assert.assertTrue(blouseLinkPageHeader.isDisplayed());

    }

    @Test
    public void checkingDressBar() {
        // Go to Dresses Bar click and verify the page
        WebElement dressesBar = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));
        dressesBar.click();
        Utility.waits(1);
        WebElement dressesBarPageHeader = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[1]"));
        Assert.assertTrue(dressesBarPageHeader.isDisplayed());
        // Go to the home page hover over 'Dresses' bar and click 'Casual Dresses'
        WebElement goToHomePage = driver.findElement(By.xpath("(//i[@class='icon-home'])[1]"));
        Utility.waits(1);
        WebElement dressesBar1 = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dressesBar1).perform();
        WebElement casualDressLink = driver.findElement(By.xpath("(//a[@title='Casual Dresses'][normalize-space()='Casual Dresses'])[2]"));
        casualDressLink.click();
        Utility.waits(2);
        // verify the casual dress link page
        WebElement casualDressLinkPageHeader = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[1]"));
        Assert.assertTrue(casualDressLinkPageHeader.isDisplayed());
        // Go to the home page hover over 'Dresses' bar and click 'Evening Dresses'
        WebElement goToHomePage1 = driver.findElement(By.xpath("(//i[@class='icon-home'])[1]"));
        Utility.waits(1);
        WebElement dressesBar2 = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(dressesBar2).perform();
        WebElement eveningDressLink = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[2]/a"));
        eveningDressLink.click();
        Utility.waits(2);
        // verify the Evening dress link page
        WebElement eveningDressLinkPageHeadr = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[1]"));
        Assert.assertTrue(eveningDressLinkPageHeadr.isDisplayed());
        // Go to the home page hover over 'Dresses' bar and click 'Summer Dresses'
        WebElement goToHomePage2 = driver.findElement(By.xpath("(//i[@class='icon-home'])[1]"));
        Utility.waits(1);
        WebElement dressesBar3 = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));
        Actions actions2 = new Actions(driver);
        actions1.moveToElement(dressesBar3).perform();
        WebElement summerDressLink = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a"));
        summerDressLink.click();
        Utility.waits(2);
        // verify the Evening dress link page
        WebElement summerDressLinkPageHeader = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[1]"));
        Assert.assertTrue(summerDressLinkPageHeader.isDisplayed());
    }

    @Test
    public void checkingTShirtsBar() {
        //Go and Click to the T-Shirts Bar
        WebElement tshirtsBar = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"));
        tshirtsBar.click();
        // verify the page
        WebElement tshirtsBarPageHeader = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[1]"));
        Assert.assertTrue(tshirtsBarPageHeader.isDisplayed());
        Utility.waits(2);
    }
}
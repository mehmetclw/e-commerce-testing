package com.ecommerce.pages;

import com.ecommerce.elements.TestTheNavigationElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestTheNavigationPages {

    WebDriver driver;

    TestTheNavigationElements tne;

    public TestTheNavigationPages(WebDriver driver) {
        this.driver = driver;
    }

    public String email = ConfigReader.getProperty("email");
    public String password = "";

    public void checkingWomenBar() {
        tne = new TestTheNavigationElements(driver);
        tne.womenTab.click();
        Assert.assertTrue(tne.womenPageHeader.isDisplayed());
        Utility.waits(1);
        Utility.hoverOver(driver, tne.womenTab2, 2);
        Utility.waits(1);
        tne.tShirtLink.click();
        Utility.waits(2);
        Assert.assertTrue(tne.tShirtPageHeader.isDisplayed());
        Utility.hoverOver(driver, tne.womenTab3, 2);
        tne.blouseLink.click();
        Utility.waits(1);
        Assert.assertTrue(tne.blouseLinkPageHeader.isDisplayed());
        Utility.hoverOver(driver, tne.womenTab4, 1);
        tne.casualDress.click();
        Assert.assertTrue(tne.casualDressPageHeader.isDisplayed());
        Utility.hoverOver(driver, tne.womenTab5, 1);
        tne.eveningDress.click();
        Assert.assertTrue(tne.eveningDressPageHeader.isDisplayed());
        Utility.hoverOver(driver, tne.womenTab6, 1);
        tne.summerDress.click();
        Assert.assertTrue(tne.summerDressPageHeader.isDisplayed());
    }

    public void checkingDressBar() {
        tne = new TestTheNavigationElements(driver);
        tne.dressesBar.click();
        Utility.waits(1);
        Assert.assertTrue(tne.dressesBarPageHeader.isDisplayed());
        Utility.waits(1);
        Utility.hoverOver(driver, tne.dressesBar1, 2);
        WebElement casualDressLink = driver.findElement(By.xpath("(//a[@title='Casual Dresses'][normalize-space()='Casual Dresses'])[2]"));
        casualDressLink.click();
        Utility.waits(2);
        Assert.assertTrue(tne.casualDressLinkPageHeader.isDisplayed());
        Utility.waits(1);
        Utility.hoverOver(driver, tne.dressesBar2, 2);
        tne.eveningDressLink.click();
        Utility.waits(2);
        Assert.assertTrue(tne.eveningDressLinkPageHeadr.isDisplayed());
        Utility.waits(1);
        Utility.hoverOver(driver, tne.dressesBar3, 2);
        tne.summerDressLink.click();
        Utility.waits(2);
        Assert.assertTrue(tne.summerDressLinkPageHeader.isDisplayed());
    }
    public void checkingTShirtsBar() {
        tne = new TestTheNavigationElements(driver);
        tne.tshirtsBar.click();
        Assert.assertTrue(tne.tshirtsBarPageHeader.isDisplayed());
        Utility.waits(2);
    }

}

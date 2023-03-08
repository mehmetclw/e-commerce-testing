package com.ecommerce.pages;

import com.ecommerce.elements.TestTheNavigationElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestTheNavigationPages extends Utility {

    TestTheNavigationElements tne;

    public void checkingWomenBar() {
        tne = new TestTheNavigationElements();
        tne.womenTab.click();
        Assert.assertTrue(tne.womenPageHeader.isDisplayed());
        waits(1);
        hoverOver( tne.womenTab2, 2);
        waits(1);
        tne.tShirtLink.click();
        waits(2);
        Assert.assertTrue(tne.tShirtPageHeader.isDisplayed());
        hoverOver( tne.womenTab3, 2);
        tne.blouseLink.click();
        waits(1);
        Assert.assertTrue(tne.blouseLinkPageHeader.isDisplayed());
        hoverOver(tne.womenTab4, 1);
        tne.casualDress.click();
        Assert.assertTrue(tne.casualDressPageHeader.isDisplayed());
        hoverOver( tne.womenTab5, 1);
        tne.eveningDress.click();
        Assert.assertTrue(tne.eveningDressPageHeader.isDisplayed());
        hoverOver( tne.womenTab6, 1);
        tne.summerDress.click();
        Assert.assertTrue(tne.summerDressPageHeader.isDisplayed());
    }

    public void checkingDressBar() {
        tne = new TestTheNavigationElements();
        tne.dressesBar.click();
        waits(1);
        Assert.assertTrue(tne.dressesBarPageHeader.isDisplayed());
        waits(1);
        hoverOver(tne.dressesBar1, 2);
        tne.casualDressLink.click();
        waits(2);
        Assert.assertTrue(tne.casualDressLinkPageHeader.isDisplayed());
        waits(1);
        hoverOver( tne.dressesBar2, 2);
        tne.eveningDressLink.click();
        waits(2);
        Assert.assertTrue(tne.eveningDressLinkPageHeadr.isDisplayed());
        waits(1);
        Utility.hoverOver(tne.dressesBar3, 2);
        tne.summerDressLink.click();
        waits(2);
        Assert.assertTrue(tne.summerDressLinkPageHeader.isDisplayed());
    }
    public void checkingTShirtsBar() {
        tne = new TestTheNavigationElements();
        tne.tshirtsBar.click();
        Assert.assertTrue(tne.tshirtsBarPageHeader.isDisplayed());
        waits(2);
    }

}

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
import org.testng.asserts.SoftAssert;

public class TestTheNavigationPages extends Utility {
    SoftAssert sf = new SoftAssert();
    TestTheNavigationElements tne;

    public void checkingWomenBar() {
        tne = new TestTheNavigationElements();
        clickElement(tne.womenTab);
        sf.assertTrue(tne.womenPageHeader.isDisplayed());
        waits(1);
        hoverOver( tne.womenTab2, 2);
        waits(1);
        clickElement(tne.tShirtLink);
        waits(2);
        sf.assertTrue(tne.tShirtPageHeader.isDisplayed());
        hoverOver( tne.womenTab3, 2);
        clickElement(tne.blouseLink);
        waits(1);
        sf.assertTrue(tne.blouseLinkPageHeader.isDisplayed());
        hoverOver(tne.womenTab4, 1);
        clickElement(tne.casualDress);
        sf.assertTrue(tne.casualDressPageHeader.isDisplayed());
        hoverOver( tne.womenTab5, 1);
        clickElement(tne.eveningDress);
        sf.assertTrue(tne.eveningDressPageHeader.isDisplayed());
        hoverOver( tne.womenTab6, 1);
        tne.summerDress.click();
        sf.assertTrue(tne.summerDressPageHeader.isDisplayed());
    }

    public void checkingDressBar() {
        tne = new TestTheNavigationElements();
        clickElement(tne.dressesBar);
        waits(1);
        sf.assertTrue(tne.dressesBarPageHeader.isDisplayed());
        waits(1);
        hoverOver(tne.dressesBar1, 2);
        clickElement(tne.casualDressLink);
        waits(2);
        sf.assertTrue(tne.casualDressLinkPageHeader.isDisplayed());
        waits(1);
        hoverOver( tne.dressesBar2, 2);
        clickElement(tne.eveningDressLink);
        waits(2);
        sf.assertTrue(tne.eveningDressLinkPageHeadr.isDisplayed());
        waits(1);
        hoverOver(tne.dressesBar3, 2);
        clickElement(tne.summerDressLink);
        waits(2);
        sf.assertTrue(tne.summerDressLinkPageHeader.isDisplayed());
    }
    public void checkingTShirtsBar() {
        tne = new TestTheNavigationElements();
        clickElement(tne.tshirtsBar);
        sf.assertTrue(tne.tshirtsBarPageHeader.isDisplayed());
        waits(2);
    }

}

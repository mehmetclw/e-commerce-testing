package com.ecommerce.pages;

import com.beust.ah.A;
import com.ecommerce.elements.TestShippingOptionsElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestShippingOptionsPages {
    WebDriver driver;

    TestShippingOptionsElements tsoe;

    public TestShippingOptionsPages(WebDriver driver){
        //PageFactory.initElements(driver, this);
        this.driver = driver;

    }
    public String email = ConfigReader.getProperty("userEmailEC-4");
    public String passwordKey = ConfigReader.getProperty("userPasswordEC-4");


    public void testAvailableShippingOptions(){

        tsoe=new TestShippingOptionsElements(driver);
        tsoe.clickSignIn.click();
        tsoe.emailAddress.sendKeys(email);
        Utility.waits(2);
        tsoe.passWord.sendKeys(passwordKey);
        Utility.waits(2);
        tsoe.signInButton.click();
        Utility.waits(2);
        tsoe.clickWomenLink.click();
        Utility.waits(2);

        Utility.waits(2);
        tsoe.clickTshirtLink.click();
        Utility.scrollTo(driver, tsoe.clickTshirtLink);
        //Adding first products
        driver.switchTo().frame(0);
        tsoe.chooseNumberOfTshirt.click();
        tsoe.chooseNumberOfTshirt.clear();
        tsoe.chooseNumberOfTshirt.sendKeys("2");
        Utility.waits(2);
        tsoe.clickChooseSize.click();
        tsoe.chooseSize_S.click();
        tsoe.chooseColor.click();
        tsoe.addToCart.click();
        tsoe.proceedToChckout.click();
        tsoe.proceedToCheckout1.click();
        Boolean checkFastTransOption= tsoe.fastTransOption.isDisplayed();
        Boolean checkMyCarrierOption =tsoe.myCarrierOption.isDisplayed();
        Assert.assertTrue(checkFastTransOption);
        Assert.assertTrue(checkMyCarrierOption);
        String expectedCarrierOption= "Choose a shipping option for this address: My address";
        String actualCarrierOption= tsoe.carrierOption.getText();
        Assert.assertEquals(actualCarrierOption ,expectedCarrierOption,"the shipping option is compatible to My adress");







    }


}

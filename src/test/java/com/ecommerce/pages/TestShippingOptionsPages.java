package com.ecommerce.pages;

import com.beust.ah.A;
import com.ecommerce.elements.TestShippingOptionsElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import com.ecommerce.utility.library.AppLibrary;
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
       /**TEST CASE1:Verify that the website displays the available shipping options for the user's location.
        *  Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
        *  Click sign in
        *  Fill the requirements field
        *  Enter the email address
        *  Enter the password
        *  Click on signInButton
        *  Click "Women" Link
        *  Click on Faded Short Sleeves T-shirt
        *  Choose the numbers of tshirt that you want to add
        *  Choose the size
        *  Choose the color
        *  Click on Add to Cart
        *  Click on Proceed to the Checkout
        *  check if the shipping options expected is displayed
        *  check if the shipping is compatible with the shipping options
        *
        *  */
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
        tsoe.clickTshirtLink.click();
        Utility.scrollTo(driver, tsoe.clickTshirtLink);
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
        Assert.assertEquals(actualCarrierOption ,expectedCarrierOption,"the shipping option is compatible to My address");
        /** TEST CASE2: Check that the User is able to select preferred  shipping option
         * select the second option with $7.00 FEES
         * check if the preferred shipping is selected
         * click proceed to checkout
         * */
        tsoe.deliveryOption2.click();
        tsoe.agreeTermsSelect.click();
        Assert.assertTrue(tsoe.deliveryOption2.isSelected());
        Assert.assertFalse(tsoe.deliveryOption1.isSelected());
        Utility.waits(5);
        tsoe.getProceedToCheckout2.click();
        Utility.waits(5);

        /**
         *  TEST CASE 3 :check that the cart total is updated correctly based on the selected shipping option.
         * check the total shipping
         * check the total product
         * */
        Assert.assertEquals(tsoe.totalProducts.getText(),"$33.02","product total not match");
        Assert.assertEquals(tsoe.totalShipping.getText(),"$7.00","the shipping total is not matching");
        Assert.assertEquals(tsoe.Total.getText(),"$40.02","the Total with the shipping is not match");




    }



}

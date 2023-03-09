package com.ecommerce.pages;

import com.beust.ah.A;
import com.ecommerce.elements.TestShippingOptionsElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestShippingOptionsPages extends Utility{
    TestShippingOptionsElements tsoe;

    public String email = ConfigReader.getProperty("userEmailEC-4");
    public String passwordKey = ConfigReader.getProperty("userPasswordEC-4");

    public  TestShippingOptionsPages() {
        tsoe = new TestShippingOptionsElements();
    }

    public void testAvailableShippingOptions  () {
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
        tsoe = new TestShippingOptionsElements();
        clickElement(tsoe.clickSignIn);
        sendKeyToElement(tsoe.emailAddress,email);
        Utility.waits(2);
        sendKeyToElement(tsoe.passWord,passwordKey);
        Utility.waits(2);
        clickElement(tsoe.signInButton);
        Utility.waits(2);
        tsoe.clickWomenLink.click();
        Utility.waits(2);
        clickElement(tsoe.clickTshirtLink);
        Utility.scrollTo(tsoe.clickTshirtLink);
        Driver.getDriver().switchTo().frame(0);
        clickElement(tsoe.chooseNumberOfTshirt);
        tsoe.chooseNumberOfTshirt.clear();
        sendKeyToElement(tsoe.chooseNumberOfTshirt,"2");
        Utility.waits(2);
        selectElementByIndex(tsoe.clickChooseSize,0);
        clickElement(tsoe.chooseSize_S);
        clickElement(tsoe.chooseColor);
        clickElement(tsoe.addToCart);
        clickElement(tsoe.proceedToChckout);
        clickElement(tsoe.proceedToCheckout1);
        Boolean checkFastTransOption = tsoe.fastTransOption.isDisplayed();
        Boolean checkMyCarrierOption = tsoe.myCarrierOption.isDisplayed();
        Assert.assertTrue(checkFastTransOption);
        Assert.assertTrue(checkMyCarrierOption);
        String expectedCarrierOption = "Choose a shipping option for this address: My address";
        String actualCarrierOption = tsoe.carrierOption.getText();
        Assert.assertEquals(actualCarrierOption, expectedCarrierOption, "the shipping option is compatible to My address");
        /** TEST CASE2: Check that the User is able to select preferred  shipping option
         * select the second option with $7.00 FEES
         * check if the preferred shipping is selected
         * click proceed to checkout
         * */
        clickElement(tsoe.deliveryOption2);
        clickElement(tsoe.agreeTermsSelect);
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
        Assert.assertEquals(tsoe.totalProducts.getText(), "$33.02", "product total not match");
        Assert.assertEquals(tsoe.totalShipping.getText(), "$7.00", "the shipping total is not matching");
        Assert.assertEquals(tsoe.Total.getText(), "$40.02", "the Total with the shipping is not match");
    }

}

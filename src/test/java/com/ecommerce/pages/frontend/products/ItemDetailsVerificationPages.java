package com.ecommerce.pages.frontend.products;

import com.ecommerce.elements.frontend.ItemDetailsVerificationElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ItemDetailsVerificationPages extends Utility {

    ItemDetailsVerificationElements idv;
    SoftAssert sf = new SoftAssert();

    /**
     * BrowserSetup
     */
    public String userId = ConfigReader.getProperty("userEmailEC-4");
    public String userPassword = ConfigReader.getProperty("userPasswordEC-4");

    public void setup() {

        idv = new ItemDetailsVerificationElements();
        clickElement(idv.signInLink);

        //Filling the requirement fields with valid credentials
        sendKeyToElement(idv.email,userId);
        sendKeyToElement(idv.password,userPassword);
        clickElement(idv.signInButton);
        Utility.waits(1);

        //Going to "Women" link
        clickElement(idv.womenLink);
    }

    public void pageDetailsVerif() {
        // Expected Texts on the product page
        String expectedItemName = "Faded Short Sleeves T-shirt";
        String expectedItemExp = "Faded short sleeves t-shirt with high neckline." +
                " Soft and stretchy material for a comfortable fit." +
                " Accessorize with a straw hat and you're ready for summer!";
        String expectedItemPrice = "$16.51";
        String expectedAddCheckText = "Product successfully added to your shopping cart";
        String expectedItemPageTitle = "Faded Short Sleeves T-shirt - My Store";

        //Going to first product in the page

        Utility.scrollToCenter( idv.pageProducts.get(0));
        Utility.hoverOver( idv.pageProducts.get(0), 1);
        clickElement(idv.pageProducts.get(0));

        // Getting product details from the page
        Utility.scrollToCenter( idv.actualItemDescription);
        String actualItemPageTitle = Driver.getDriver().getTitle();
        String actualItemName = getTextElement(idv.actualItemTitle);
        String actualItemExplanation = getTextElement(idv.actualItemDescription);
        String actualItemPrice = getTextElement(idv.actualItemSale);

        //Checking product details
        sf.assertEquals(actualItemPageTitle, expectedItemPageTitle, "PAGE TITLE DOES NOT MATCH");
        sf.assertEquals(actualItemName, expectedItemName, "PRODUCT NAME DOES NOT MATCH.");
        sf.assertEquals(actualItemExplanation, expectedItemExp, "PRODUCT DESCRIPTION DOES NOT MATCH.");
        sf.assertEquals(actualItemPrice, expectedItemPrice, "PRODUCT PRICE DOES NOT MATCH.");
        Utility.waits(1);

        //Adding product to cart
        clickElement(idv.addToCart);

        //Checking to add message
        Utility.waits(1);
        String actualAddCheckText = idv.checkAddMessage.getText();
        sf.assertEquals(actualAddCheckText, expectedAddCheckText, "PRODUCT DOES NOT ADDED.");
        sf.assertAll();
        Utility.waits(1);

    }

    public void windowDetailsVerif() {
        // Expected Texts on the product page
        String expectedItemName = "Faded Short Sleeves T-shirt";
        String expectedItemExp = "Faded short sleeves t-shirt with high neckline." +
                " Soft and stretchy material for a comfortable fit." +
                " Accessorize with a straw hat and you're ready for summer!";
        String expectedItemPrice = "$16.51";
        String expectedAddCheckText = "SHOPPING-CART SUMMARY";

        //Going to first product in the page
        Utility.scrollToCenter(idv.pageProducts.get(0));
        Utility.waits(1);
        Utility.hoverOver(idv.pageProducts.get(0), 1);
        Assert.assertTrue(Utility.isElementVisible(idv.quickview, 1));
        clickElement(idv.quickview);
        Driver.getDriver().switchTo().frame(idv.iframeLocator);

        // Getting product details from the opening window
        String actualItemName = idv.actualItemWindowTitle.getText();
        String actualItemExplanation = idv.actualItemDescription.getText();
        String actualItemPrice = idv.actualItemSale.getText();

        //Checking product details
        sf.assertEquals(actualItemName, expectedItemName, "PRODUCT NAME DOES NOT MATCH.");
        sf.assertEquals(actualItemExplanation, expectedItemExp, "PRODUCT DESCRIPTION DOES NOT MATCH.");
        sf.assertEquals(actualItemPrice, expectedItemPrice, "PRODUCT PRICE DOES NOT MATCH.");
        Utility.waits(1);
        
        //Adding product to cart
        clickElement(idv.addToCart);
        Utility.waits(1);

        //Checking to add message
        String actualAddCheckText = getTextElement(idv.checkWindowAddMessage);
        sf.assertTrue(actualAddCheckText.contains(expectedAddCheckText), "PRODUCT DOES NOT ADDED.");
        sf.assertAll();
    }
}

package com.ecommerce.pages;

import com.ecommerce.elements.ItemDetailsVerificationElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class ItemDetailsVerificationPages {

    WebDriver driver;
    ItemDetailsVerificationElements idv;
    SoftAssert sf = new SoftAssert();

    public ItemDetailsVerificationPages(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * BrowserSetup
     */
    public String userId = ConfigReader.getProperty("userEmailEC-4");
    public String userPassword = ConfigReader.getProperty("userPasswordEC-4");

    public void setup() {

        idv = new ItemDetailsVerificationElements(driver);
        idv.signInLink.click();

        //Filling the requirement fields with valid credentials
        idv.email.sendKeys(userId);
        idv.password.sendKeys(userPassword);
        idv.signInButton.click();
        Utility.waits(1);

        //Going to "Women" link
        idv.womenLink.click();
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

        Utility.scrollToCenter(driver, idv.pageProducts.get(0));
        Utility.hoverOver(driver, idv.pageProducts.get(0), 1);
        idv.pageProducts.get(0).click();

        // Getting product details from the page
        Utility.scrollToCenter(driver, idv.actualItemDescription);
        String actualItemPageTitle = driver.getTitle();
        String actualItemName = idv.actualItemTitle.getText();
        String actualItemExplanation = idv.actualItemDescription.getText();
        String actualItemPrice = idv.actualItemSale.getText();

        //Checking product details
        sf.assertEquals(actualItemPageTitle, expectedItemPageTitle, "PAGE TITLE DOES NOT MATCH");
        sf.assertEquals(actualItemName, expectedItemName, "PRODUCT NAME DOES NOT MATCH.");
        sf.assertEquals(actualItemExplanation, expectedItemExp, "PRODUCT DESCRIPTION DOES NOT MATCH.");
        sf.assertEquals(actualItemPrice, expectedItemPrice, "PRODUCT PRICE DOES NOT MATCH.");
        Utility.waits(1);

        //Adding product to cart
        idv.addToCart.click();

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
        Utility.scrollToCenter(driver, idv.pageProducts.get(0));
        Utility.waits(1);
        Utility.hoverOver(driver, idv.pageProducts.get(0), 1);
        Assert.assertTrue(Utility.isElementVisible(driver, idv.quickview, 1));
        idv.quickview.click();
        driver.switchTo().frame(idv.iframeLocator);

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
        idv.addToCart.click();
        Utility.waits(1);

        //Checking to add message
        String actualAddCheckText = idv.checkWindowAddMessage.getText();
        sf.assertTrue(actualAddCheckText.contains(expectedAddCheckText), "PRODUCT DOES NOT ADDED.");
        sf.assertAll();
    }
}

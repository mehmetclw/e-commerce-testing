package com.ecommerce.tests;
    import com.ecommerce.pages.ShoppingCartPages;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

    public class ShoppingCartTest {

        /*Acceptance Criteria:

         a. Add a product to the cart and verify that it is added correctly.

         b. Remove a product from the cart and verify that it is removed correctly.

         c. Verify that the cart total is calculated correctly.*/


        /**
         * Happy Path Story
         * <p>
         * *1)Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
         * 2)Click sign in
         * 3)Fill the requirements field
         * Enter the email address
         * Enter the password
         * Click on signInButton
         * Verify title of page is matching
         * 4)Click "Women" section
         * 5)Check if the actualTitle and expectedTitle is same
         * 6)Add a product to the cart and verify that it is added correctly.
         * Click on Faded Short Sleeves T-shirt
         * Choose the numbers of tshirt that you want to add
         * Choose the size
         * Choose the color
         * Click on Add to Cart
         * 7)Go back to back page
         * 8)Add another product
         * Click on Printed Dress
         * Click add to cart
         * 9)Click on Proceed to the Checkout
         * 10)Check if the product added correctly
         * Verify cart titles are matching
         * Verify if you get "Your shopping cart contains: 3 product"
         * 11)Remove a product from the cart and verify that it is removed correctly.
         * Click to the delete button
         * Check if you get "Your shopping cart contains: 1 products"
         * 12)Verify that the cart total is calculated correctly.
         * Delete one of option
         * Check if the total price is matching with price that shown on website "$26.00"
         */

        WebDriver driver;

        ShoppingCartPages scp;
        public String url = ConfigReader.getProperty("url");
        public String email = ConfigReader.getProperty("emailAddress");
        public String passwordKey = ConfigReader.getProperty("passwordKey");

        @BeforeMethod
        public void browserSetup() {
            //Setting the browser
            driver = WebDriverManager.chromedriver().create();
            //driver = WebDriverManager.chromedriver().setup();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);
            scp = new ShoppingCartPages(driver);
        }

        @Test
        public void addAndRemoveToCart() {
            if (driver != null)
                scp.addAndRemoveToCart();
            else System.out.println("Driver is null");


        }
    }





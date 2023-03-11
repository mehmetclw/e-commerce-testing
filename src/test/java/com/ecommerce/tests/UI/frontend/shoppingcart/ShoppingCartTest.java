package com.ecommerce.tests.UI.frontend.shoppingcart;

import com.ecommerce.tests.TestBase.TestBase;
import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase {

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
     * 4)Click "Women" Link
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

    public String url = ConfigReader.getProperty("url");
    public String email = ConfigReader.getProperty("emailAddress");

    @Test(groups = {"smoke","resgression"},
    description = "Add Remove products from shopping cart")
    public void addAndRemoveToCart() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getScp().addAndRemoveToCart();
    }

    //Negative Path Story
    /**
     * 1)Go to home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
     * 2)Click Sign in //a[normalize-space()='Sign in']
     * Enter email address that have already been registered //input[@id='email_create']
     * 3)Click create an account //span[normalize-space()='Create an account']
     * Verify that the email is already registered "An account using this email address has already been registered.
     * Please enter a valid password or request a new one."
     * 4)Click email address and enter valid email address
     * //         * 5)Click register //span[text()='Register']
     * Verify that user missed to field the required fields
     * There are 3 errors
     * 1.lastname is required.
     * 2.firstname is required.
     * 3.passwd is required.
     * 6)Enter first name //input[@id='customer_firstname']
     * 7)Enter last name //input[@id='customer_lastname']
     * 8)Enter less than 5 character //input[@id='passwd']
     * 9)Click register //span[text()='Register']
     * Verify that user needed to enter minimum 5 character
     * 1.There is 1 error
     * passwd is invalid.
     */

    @Test(groups = "regression",
    description = "Verify invalid email will not work")
    public void invalidEmail() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getScp().invalidEmail();
    }

}





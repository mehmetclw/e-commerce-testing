package com.ecommerce.pages;

import com.ecommerce.elements.ReturningUserPurchaseElements;
import com.ecommerce.elements.TestShippingOptionsElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import com.github.javafaker.Bool;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturningUserPurchasePages extends Utility {
    ReturningUserPurchaseElements rupe=new ReturningUserPurchaseElements();

    public String email = ConfigReader.getProperty("userEmailEC-4");
    public String passwordKey = ConfigReader.getProperty("userPasswordEC-4");
  /**  Description
    Returning user purchase
    URL: https://ecommerce.yosemiteint.com/prestashop/index.php
    Open the website and login with valid credentials.
    Search for a product using the search bar.
    Click on a product to view the details page.
    Click on the "Add to cart" button.
    Verify that the product is added to the cart and the cart total is updated.
    Click on the "Proceed to checkout" button.
    Verify that the previously saved address details are pre-filled.
    Select a payment method and click on the "Place order" button.
    Verify that the order is placed successfully and the user is redirected to the order confirmation page
    Acceptance Criteria:
    Verify that user should be able to see his/her previous details and successfully place the order
   and redirected to the order confirmation page.*/
public void returningUserPurchase(){
    /** Test Case1:Successful placement order */

    clickElement(rupe.clickSignIn);
    sendKeyToElement(rupe.emailAddress,email);
    Utility.waits(2);
    sendKeyToElement(rupe.passWord,passwordKey);
    Utility.waits(2);
    clickElement(rupe.signInButton);
    Utility.waits(2);
    clickElement(rupe.searchBox);
    sendKeyToElement(rupe.searchBox,"T-shirt");
    clickElement(rupe.searchButton);
    clickElement(rupe.imageComponent);
    clickElement(rupe.addToCart);
    clickElement(rupe.proceedToCheckout);
    //Verify the product is added to cart
    String expectedShoppingSummary="Your shopping cart contains: 1 product";
    Assert.assertEquals(rupe.shoppingCartSummary.getText(),expectedShoppingSummary,"cart doesn't have your product");
    String expectedQuantity="1 product";
    Assert.assertEquals(rupe.summaryProductQuantity.getText(),expectedQuantity,"product not in the cart");
    //verify the cart total
    String expectedTotal="$16.51";
    Assert.assertEquals(rupe.totalCart.getText(),expectedTotal,"TOTAL DOESN'T MATCH");
    scrollTo(rupe.proceedToCheckout1);
    clickElement(rupe.proceedToCheckout1);
    String expectedUserStreet="123 knollwood";
    String expectedUserCityState="lynchburg, Virginia 24502";
    Assert.assertEquals(rupe.userStreetAddress.getText(),expectedUserStreet,"the user Street is not valid");
    Assert.assertEquals(rupe.userCityStateAddress.getText(),expectedUserCityState,"the user city and state not valid");
   clickElement(rupe.getProceedToCheckout2);
   rupe.checkAgreeTerms.click();
   clickElement(rupe.getProceedToCheckout3);
   clickElement(rupe.payByCheck);
   clickElement(rupe.confirmMyOrderButton);
    /** test Case2 : user able to redirect to order confirmation page and get all the details */
    clickElement(rupe.viewOrderHistoryButton);
    clickElement(rupe.orderDetailsButton);
    //check the order confirmation page
    String expectedMessage="ORDER HISTORY";
   Assert.assertEquals(rupe.OrderHistory.getText(),expectedMessage,"your order doesn't confirm");
   clickElement(rupe.viewOrderHistoryButton);




}



}

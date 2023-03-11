package com.ecommerce.pages.frontend.shoppingcart;

import com.ecommerce.elements.frontend.ShoppingCartProductQuantityElements;
import com.ecommerce.utility.Utility;
import org.testng.asserts.SoftAssert;

public class ShoppingCartProductQuantityPages extends Utility {
    ShoppingCartProductQuantityElements scpqe;
public ShoppingCartProductQuantityPages(){
    scpqe = new ShoppingCartProductQuantityElements();
}
     SoftAssert sf= new SoftAssert();
    public void increaseQuantityAndDecrease() {

        hoverOver(scpqe.clickAnyProduct,1);
        waits(1);
        clickElement(scpqe.addProductToCart);
        waits(1);
        clickElement(scpqe.checkOut);
        waits(3);
        clickElement(scpqe.increaseQuantityOfProduct);
        waits(2);
        String expectedItemPrice = "$60.00";
        String actualItemPrice= scpqe.afterIncreaseProductPrice.getText();
        sf.assertEquals(actualItemPrice,expectedItemPrice);
        clickElement(scpqe.decreaseQuantityOfProduct);
        waits(2);
        String expectedItemPrice2 = "$30.00";
        String actualItemPrice2=scpqe.afterDecreaseProductPrice.getText();
        sf.assertEquals(actualItemPrice2,expectedItemPrice2);
    }
}

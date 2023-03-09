package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShoppingCartProductQuantityTest extends TestBase {
    SoftAssert sf = new SoftAssert();
    public String url = ConfigReader.getProperty("url");
    @Test(groups = {"smoke","regression"},
    description = "EC-18 UI | Test the product quantity in shopping cart")
    public void increaseQuantityAndDecrease() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getScpqp().increaseQuantityAndDecrease();

    }
}



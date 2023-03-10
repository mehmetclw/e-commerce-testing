package com.ecommerce.pages.frontend.homepage;

import com.ecommerce.elements.frontend.HomePageElement;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends Utility {
    public HomePageElement homePageElement;

    public HomePage() {
        homePageElement = new HomePageElement();
    }

    public void verifyHomePage() {
        boolean check = isClickable(homePageElement.searchButton, 10);
        Assert.assertTrue(check);
        scrollToCenter(homePageElement.image);
        waits(4);
        scrollTo(homePageElement.myAccountLink);
        waits(4);
        clickElement(homePageElement.myAccountLink);
    }

    public void checkHomePageProductsPage() {
        scrollToCenter(homePageElement.homePageProducts.get(0));
        //Try to verify each price is as expected after hoverover
        for (WebElement product : homePageElement.homePageProducts) {
            hoverOver(product, 1);
        }
    }

}

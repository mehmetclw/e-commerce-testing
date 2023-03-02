package com.ecommerce.pages;

import com.ecommerce.elements.ShoppingCartElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCartPages {

    WebDriver driver;
    ShoppingCartElements sce;

    public ShoppingCartPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String email = ConfigReader.getProperty("emailAddress");
    public String passwordKey = ConfigReader.getProperty("passwordKey");


    public void addAndRemoveToCart() {
        //Filling required validate credential
        sce = new ShoppingCartElements(driver);
        sce.clickSignIn.click();
        sce.emailAdress.sendKeys(email);
        Utility.waits(2);
        sce.password.sendKeys(passwordKey);
        Utility.waits(2);
        sce.signInButton.click();
        Utility.waits(2);

        //Checking if the titles are equal
        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title didn't match");


        //Clicking on Women link
        sce.clickWomenLink.click();

        //Verifying the title
        String expectedTitleInTitle = "Women - My Store";
        String actualTitleInLine = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles are matching");

        Utility.waits(2);
        sce.clickTshirtLink.click();
        Utility.scrollTo(driver, sce.clickTshirtLink);


        //Adding first products
        driver.switchTo().frame(0);
        sce.chooseNumberOfTshirt.click();
        sce.chooseNumberOfTshirt.clear();
        sce.chooseNumberOfTshirt.sendKeys("2");
        Utility.waits(2);
        sce.clickChooseSize.click();
        sce.chooseSize_S.click();
        sce.chooseColor.click();
        sce.addToCart.click();
        driver.navigate().back();

        //Adding second product
        sce.clickDress.get(2).click();
        sce.addToCart1.click();
        Utility.waits(1);

        //Verifying if the titles are equal
        String expectedInLineTitle = "Printed Dress - My Store";
        String actualInLineTitle = driver.getTitle();
        Assert.assertEquals(actualInLineTitle, expectedInLineTitle, "Titles are not matching");
        Utility.waits(2);

        sce.proceedToCheckOut.click();
        //Verifying if the title is true
        Boolean checkPageofProceedCalc = driver.getTitle().equalsIgnoreCase("Order - My Store");
        Assert.assertTrue(checkPageofProceedCalc);

        //Deleting the product
        Utility.scrollToCenter(driver,sce.proceedToCheckOut);
        sce.clickDeleteButton.get(0).click();
        Utility.waits(5);

        //Verifying if the titles are equal
        String actualCartTitle = sce.cartTitleCheck.getText();
        String expectedCartTitle = "SHOPPING-CART SUMMARY\n" + "Your shopping cart contains: 1 product";
        Assert.assertEquals(actualCartTitle, expectedCartTitle, "Cart titles are matching");
        Utility.waits(2);

        //Verifying the total calculation is displayed
        Boolean checkTotalCalculation = sce.totalCalculation.isDisplayed();
        Assert.assertTrue(checkTotalCalculation);
        System.out.println("Total price without tax is $26");

    }
}



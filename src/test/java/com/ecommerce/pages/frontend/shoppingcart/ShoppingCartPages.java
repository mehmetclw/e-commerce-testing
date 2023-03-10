package com.ecommerce.pages.frontend.shoppingcart;

import com.ecommerce.elements.frontend.ShoppingCartElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.testng.Assert;

public class ShoppingCartPages extends Utility{

    ShoppingCartElements sce;
    public ShoppingCartPages(){ sce = new ShoppingCartElements();}

    public String email = ConfigReader.getProperty("emailAddress");
    public String passwordKey = ConfigReader.getProperty("passwordKey");

    public String numberOfTshirt=ConfigReader.getProperty("numberOfTshirt");

    public void addAndRemoveToCart() {
        //Filling required validate credential
        clickElement(sce.clickSignIn);
        sendKeyToElement(sce.emailAdress, ConfigReader.getProperty("emailAddress"));
        waits(2);
        sendKeyToElement(sce.password, ConfigReader.getProperty("passwordKey"));
        waits(2);
        clickElement(sce.signInButton);
        waits(2);

        //Checking if the titles are equal
        String expectedTitle = "My account - My Store";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title didn't match");

        //Clicking on Women link
        clickElement(sce.clickWomenLink);

        //Verifying the title
        String expectedTitleInTitle = "Women - My Store";
        String actualTitleInLine = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles are matching");

        waits(2);
        clickElement(sce.clickTshirtLink);
        scrollTo( sce.clickTshirtLink);


        //Adding first products
        Driver.getDriver().switchTo().frame(0);
        clickElement(sce.chooseNumberOfTshirt);
        clearElement(sce.chooseNumberOfTshirt);
        sendKeyToElement(sce.chooseNumberOfTshirt,"2");
        waits(3);
        selectElementByIndex(sce.clickChooseSize, 1);
        //clickElement(sce.chooseSize_S);
        clickElement(sce.chooseColor);
        clickElement(sce.addToCart);
        Driver.getDriver().navigate().back();

        //Adding second product
        clickElement(sce.clickDress.get(2));
        clickElement(sce.addToCart1);
        waits(1);

        //Verifying if the titles are equal
        String expectedInLineTitle = "Printed Dress - My Store";
        String actualInLineTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualInLineTitle, expectedInLineTitle, "Titles are not matching");
        waits(2);

        clickElement(sce.proceedToCheckOut);
        //Verifying if the title is true
        Boolean checkPageofProceedCalc = Driver.getDriver().getTitle().equalsIgnoreCase("Order - My Store");
        Assert.assertTrue(checkPageofProceedCalc);

        //Deleting the product
        scrollToCenter(sce.proceedToCheckOut);
        clickElement(sce.clickDeleteButton.get(1));
        waits(5);

        //Verifying if the titles are equal
        String actualCartTitle = getTextElement(sce.cartTitleCheck);
        String expectedCartTitle = "SHOPPING-CART SUMMARY\n" + "Your shopping cart contains: 2 products";
        Assert.assertEquals(actualCartTitle, expectedCartTitle, "Cart titles are matching");
        waits(2);

        //Verifying the total calculation is displayed
        Boolean checkTotalCalculation = sce.totalCalculation.isDisplayed();
        Assert.assertTrue(checkTotalCalculation);
        System.out.println("Total price without tax is $26");

    }

    public void invalidEmail(){
        //Creating account
        clickElement(sce.clickSignInLink);
        clickElement(sce.clickEmailAddress);
        sendKeyToElement(sce.clickEmailAddress,ConfigReader.getProperty("emailAddress"));
        clickElement(sce.clickCreateAccount);
        // Verifying that the email is already registered
        String actualTitle = getTextElement(sce.checkInvalidEmail);
        String expectedTitle = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        Assert.assertEquals(actualTitle, expectedTitle, "Titles are not matching");
        waits(2);

        //Filling required fields
        clickElement(sce.clickEmailAddress);
        clearElement(sce.clickEmailAddress);
        sendKeyToElement(sce.clickEmailAddress,"abcd1@gmail.com");
        clickElement(sce.clickCreateAccount);
        clickElement(sce.register);

        clickElement(sce.firstName);
        sendKeyToElement(sce.firstName,"elifnur");
        clickElement(sce.register);
        //Verifying that user missed to field the required fields
        String actualTitle1 = getTextElement(sce.checkInvalidLastname);
        String expectedTitle1 = "lastname is required.";
        Assert.assertEquals(actualTitle1, expectedTitle1, "Titles are NOT matching");
        waits(2);

        //Again filling the required fields
        clickElement(sce.firstName);
        sendKeyToElement(sce.firstName,"elif");
        clickElement(sce.lastName);
        sendKeyToElement(sce.lastName,"birer");
        waits(2);
        clickElement(sce.invalidPassword);
        sendKeyToElement(sce.invalidPassword,"12");
        Utility.waits(7);
        clickElement(sce.clickRegister);

        //Verifying that user entered invalid password
        String actualTitle2 = getTextElement(sce.checkInvalidPassword);
        String expectedTitle2 = "passwd is invalid.";
        Assert.assertEquals(actualTitle2, expectedTitle2, "NOT matching");
    }
}

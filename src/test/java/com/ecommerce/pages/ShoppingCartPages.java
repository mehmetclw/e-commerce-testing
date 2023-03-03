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

    public void invalidEmail(){
        sce = new ShoppingCartElements(driver);

        //Creating account
        sce.clickSignInLink.click();
        sce.clickEmailAddress.click();
        sce.clickEmailAddress.sendKeys(email);
        sce.clickCreateAccount.click();
        // Verifying that the email is already registered
        String actualTitle = sce.checkInvalidEmail.getText();
        String expectedTitle = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        Assert.assertEquals(actualTitle, expectedTitle, "Titles are not matching");
        Utility.waits(2);

        //Filling required fields
        sce.clickEmailAddress.click();
        sce.clickEmailAddress.clear();
        sce.clickEmailAddress.sendKeys("abcd1@gmail.com");
        sce.clickCreateAccount.click();
        sce.register.click();

        sce.firstName.click();
        sce.firstName.sendKeys("elifnur");
        sce.register.click();
        //Verifying that user missed to field the required fields
        String actualTitle1 = sce.checkInvalidLastname.getText();
        String expectedTitle1 = "lastname is required.";
        Assert.assertEquals(actualTitle1, expectedTitle1, "Titles are NOT matching");
        Utility.waits(2);

        //Again filling the required fields
        sce.firstName.click();
        sce.firstName.sendKeys("elif");
        sce.lastName.click();
        sce.lastName.sendKeys("birer");
        Utility.waits(2);
        sce.invalidPassword.click();
        sce.invalidPassword.sendKeys("12");
        Utility.waits(7);
        sce.clickRegister.click();

        //Verifying that user entered invalid password
        String actualTitle2 = sce.checkInvalidPassword.getText();
        String expectedTitle2 = "passwd is invalid.";
        Assert.assertEquals(actualTitle2, expectedTitle2, "NOT matching");






    }
}

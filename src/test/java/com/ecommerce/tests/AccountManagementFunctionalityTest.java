package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import org.testng.annotations.Test;

public class AccountManagementFunctionalityTest extends TestBase {

    // Happy Path
    /**
     * 1)Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
     * Verify you are in home page "Expected title=My Store"
     *          * Click sign in //a[normalize-space()='Sign in']
     *          * Fill the requirements field
     *          *        Enter the email address //input[@id='email']
     *          * Enter the password  //input[@id='passwd']
     *          * Click on signInButton //span[normalize-space()='Sign in']
     * Verify that user signed in //p[@class='info-account']
     *          "Welcome to your account. Here you can manage all of your personal information and orders."
     * Click on ORDER HISTORY AND DETAILS "//span[text()='Order history and details']"
     * Verify that user can see history of order //p[@class='info-title']
     *           "Here are the orders you've placed since your account was created."
     *
     * 2)Navigate to back
     *Click on MY PERSONAL INFORMATION  //span[text()='My personal information']
     *Update password
     *      Click on current password and enter current password //input[@id='old_passwd']
     *      Click on new password and enter new password //input[@id='passwd']
     *      Click on confirm the password and enter new password //input[@id='confirmation']
     *     Click on save button //span[normalize-space()='Save']
     *
     *Verify that user updated password succesfully //p[@class='alert alert-success']
     *      "Your personal information has been successfully updated."
     *
     *
     *3)Click on "my account" link  //a[@itemprop='url']
     *       Click on MY ADDRESSES  //span[text()='My addresses']
     *       Click on update button under my address //ul[@class='first_item item box']//span[text()='Update']
     *       Click on "Address" and enter new address that you want to change //input[@id='address1']
     *       Click on save button //span[normalize-space()='Save']
     *Verify that user changed address successfully
     * //ul[@class='first_item item box']//span[@class='address_address1'][normalize-space()='123 Street']

     */

    //Negative Path
    /**
     * 1)Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
     * * Click sign in //a[normalize-space()='Sign in']
     * * Fill the requirements field
     * *        Enter the email address //input[@id='email']
     * *        Enter the password //input[@id='passwd']
     * *        Click on signInButton //span[normalize-space()='Sign in'
     * Verify that user signed in //p[@class='info-account']
     * "Welcome to your account. Here you can manage all of your personal information and orders.
     * Click on MY PERSONAL INFORMATION //span[text()='My personal information']
     * Click on "First name" and change name //input[@id='firstname']
     * Click on current password and enter current password //input[@id='old_passwd']
     * Click on new password and enter new password //input[@id='passwd']
     * Click on confirm the password and enter new password //input[@id='confirmation']
     * Click on save button //span[normalize-space()='Save']
     * Verify that user is not able to change first name.
     * "firstname is invalid." //div[@class='alert alert-danger']//li
     */

    public String url = ConfigReader.getProperty("url");
    public String email = ConfigReader.getProperty("emailAddress1");
    public String password = ConfigReader.getProperty("password");

    @Test(groups = {"smoke", "regression"},
            description = "EC-10 Test the account management functionality")
    public void accountUpdate() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getAmfp().accountUpdate();
    }

    @Test(groups = {"smoke", "regression"},
            description = "EC-10 Test the account management functionality for negative test case")
    public void invalidFirstName() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getAmfp().invalidFirstName();
    }
}

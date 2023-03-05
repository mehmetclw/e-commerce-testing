package com.ecommerce.tests;

import com.ecommerce.dataprovider.DataProviderTest;
import com.ecommerce.pages.UserRegistrationPages;
import com.ecommerce.utility.ConfigReader;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserRegistrationTest extends TestBase{
    public String url = ConfigReader.getProperty("url");
    /**
     * Enter valid details and check if the user is able to register successfully.
     * 1- Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
     * 2- click sign in  //a[@class='login']
     * 3- Enter email  //input[@id='email_create']
     * 4- click create account  //span[text()='Create an account']
     * 6- fill the requirements field
     * Title //input[@id='id_gender2']
     * first name //input[@id='customer_firstname']
     * last name //input[@id='customer_lastname']
     * password //input[@id='passwd']
     * date of birth
     * day   //select[@id='days']//option[@value='12']  /
     * month  //select[@id='months']  /
     * year  //select[@id='years']
     * click register
     */

    @Test
    public void createNewAccount() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        if (driver != null)
            getAppLibrary().getPage().getUrp().createNewAccount();
        else System.out.println("Driver is null");
    }

    @Test
    public void fakerTest() {
        Faker fake = new Faker();
        String name = fake.name().fullName();
        String email = fake.internet().emailAddress();
        System.out.println("fake.name().firstName() = " + fake.name().firstName());
        System.out.println("fake.name().lastName() = " + fake.name().lastName());
        System.out.println("fake.name().name() = " + fake.name().name());
        System.out.println("email = " + email);
        System.out.println("name = " + name);
    }

    @Test(dataProvider = "dataProvider1", dataProviderClass = DataProviderTest.class)
    public void test5(String name, String email, String password) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(password);
        System.out.println("===========");

    }

}

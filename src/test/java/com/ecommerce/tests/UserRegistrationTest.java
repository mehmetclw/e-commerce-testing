package com.ecommerce.tests;

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

public class UserRegistrationTest {
    WebDriver driver;
    UserRegistrationPages urp;
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
    @BeforeClass
    public void browserSetup() {
        driver = WebDriverManager.chromedriver().create();
        //driver = WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        urp = new UserRegistrationPages(driver);
    }

    @Test
    public void createNewAccount() {
        if (driver != null)
            urp.createNewAccount();
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

}

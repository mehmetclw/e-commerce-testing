package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserRegistrationTest {
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
    WebDriver driver;
    public String url = ConfigReader.getProperty("url");
    public String email = ConfigReader.getProperty("email");
    public String password = "";

    /**
     * BrowserSetup
     */
    @BeforeMethod
    public void browserSetup() {
        driver = WebDriverManager.chromedriver().create();
        //driver = WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @Test
    public void createNewAccount() {

        WebElement signInButton = driver.findElement(By.xpath("//div[@class='header_user_info']/a"));
        signInButton.click();
        WebElement emailAddress = driver.findElement(By.xpath("//input[@id='email_create']"));
        emailAddress.click();
        emailAddress.sendKeys(email);
        WebElement createAccountButton = driver.findElement(By.xpath("//span[normalize-space()='Create an account']"));
        createAccountButton.click();
        WebElement mrsChecKBox = driver.findElement(By.xpath("//input[@id='id_gender2']"));
        mrsChecKBox.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        firstName.click();
        firstName.sendKeys("elif");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastName.click();
        lastName.sendKeys("topal");
        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        password.sendKeys("123elif");
        WebElement day = driver.findElement(By.xpath("//select[@id='days']"));

        Select select = new Select(day);
        select.selectByIndex(0);
        select.selectByValue("25");
        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select select2 = new Select(month);
        select2.selectByIndex(0);
        select2.selectByValue("12");
        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select select3 = new Select(year);
        select3.selectByIndex(0);
        select3.selectByValue("1990");
        WebElement register = driver.findElement(By.xpath("//span[normalize-space()='Register']"));
        register.click();
    }

    @Test
    public void fakerTest(){
        Faker fake = new Faker();
        String name = fake.name().fullName();
        String email = fake.internet().emailAddress();
        System.out.println("fake.name().firstName() = " + fake.name().firstName());
        System.out.println("fake.name().lastName() = " + fake.name().lastName());
        System.out.println("fake.name().name() = " + fake.name().name());
        System.out.println("email = " + email);
        System.out.println("name = " + name);
    }
    /**
     * waits
     */

/**
 * 2- Verify that existing customer should not able to register again.
 *
 */
}

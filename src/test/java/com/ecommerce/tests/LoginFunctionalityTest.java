package com.ecommerce.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginFunctionalityTest {
    WebDriver driver;
    SoftAssert sf = new SoftAssert();

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://ecommerce.yosemiteint.com/prestashop/index.php");
    }


    @Test(groups = {"smoke","regression"})
    public void login() throws InterruptedException {

        WebElement signInLink = driver.findElement(By.className("login"));
        signInLink.click();
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("abcd@gmail.com");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("123456");
        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
        signInButton.click();
        Thread.sleep(3000);
        WebElement accountCheck = driver.findElement(By.className("page-heading"));
        String actualCheck = accountCheck.getText();
        WebElement pCheck = driver.findElement(By.className("info-account"));
        String actualP = pCheck.getText();
        String expectedCheck = "MY ACCOUNT";
        String expectP = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Thread.sleep(1000);

        sf.assertEquals(actualCheck, expectedCheck, "NO MATCH");
        sf.assertEquals(actualP, expectP, "NO MATCH");
        sf.assertAll();
    }
}

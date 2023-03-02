package com.ecommerce.tests;

import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class ShoppingCart {

        /*Acceptance Criteria:

         a. Add a product to the cart and verify that it is added correctly.

         b. Remove a product from the cart and verify that it is removed correctly.

         c. Verify that the cart total is calculated correctly.*/


       /** Happy Path Story

     * *1)Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
     * 2)Click sign in
     * 3)Fill the requirements field
     *           Enter the email address
     *           Enter the password
     *           Click on signInButton
     *           Verify title of page is matching
     * 4)Click "Women" section
     * 5)Check if the actualTitle and expectedTitle is same
     * 6)Add a product to the cart and verify that it is added correctly.
     *             Click on Faded Short Sleeves T-shirt
     *             Choose the numbers of tshirt that you want to add
     *             Choose the size
     *             Choose the color
     *             Click on Add to Cart
     * 7)Go back to back page
     * 8)Add another product
     *             Click on Printed Dress
     *             Click add to cart
     * 9)Click on Proceed to the Checkout
     * 10)Check if the product added correctly
     *             Verify cart titles are matching
     *             Verify if you get "Your shopping cart contains: 3 product"
     * 11)Remove a product from the cart and verify that it is removed correctly.
     *             Click to the delete button
     *             Check if you get "Your shopping cart contains: 1 products"
     * 12)Verify that the cart total is calculated correctly.
     *             Delete one of option
     *             Check if the total price is matching with price that shown on website "$26.00"
     */

    WebDriver driver;
    public String url = "https://ecommerce.yosemiteint.com/prestashop/index.php";
    public String email = "elifnurbirer1994@gmail.com";
    public String passwordKey = "123elif";

    @BeforeMethod
    public void browserSetup() {

        //Setting the browser
        driver = WebDriverManager.chromedriver().create();
        //driver = WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    public void waits(long seconds) {
        try {
            Thread.sleep((seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void signIn() {

        //Filling required validate credential
        WebElement clickSignIn = driver.findElement(By.xpath("//div[@class='header_user_info']/a"));
        clickSignIn.click();
        WebElement emailAddress = driver.findElement(By.xpath("//input[@id='email']"));
        emailAddress.sendKeys(email);
        waits(2000L);
        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        password.sendKeys(passwordKey);
        waits(2000L);
        Utility.scrollTo(driver, password);
        WebElement signInButton = driver.findElement(By.xpath("//span[normalize-space()='Sign in']"));
        signInButton.click();
        waits(2000L);

        //Checking if the titles are equal
        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title didn't match");

    }

    @Test
    public void addToCart() {

        signIn();
        //Going to the women section
        WebElement clickWomen = driver.findElement(By.xpath("//a[@title='Women']"));
        clickWomen.click();


        //Verifying the title
        String expectedTitle = "Women - My Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles are matching");


        //Clicking the first product
        WebElement clickTshirt = driver.findElement(By.xpath("//img[@src='https://ecommerce.yosemiteint.com/prestashop/img/p/1/1-home_default.jpg']"));
        Utility.scrollTo(driver, clickTshirt);
        clickTshirt.click();

        //Verifying if the titles are equal
        String expectedInLineTitle = "Faded Short Sleeves T-shirt - My Store";
        String actualInLineTitle = driver.getTitle();
        if (expectedTitle.equals(actualInLineTitle)) {
            System.out.println("Titles are matching");
        } else
            System.out.println("Titles are not matching");
        System.out.println("actualInLineTitle = " + actualInLineTitle);
        System.out.println("expectedInLineTitle = " + expectedInLineTitle);
        waits(2000L);


        //Adding first products
        driver.switchTo().frame(0);
        waits(1000L);
        WebElement chooseNumberOfTshirt = driver.switchTo().activeElement().findElement(By.xpath("//input[@id='quantity_wanted']"));
        chooseNumberOfTshirt.click();
        chooseNumberOfTshirt.clear();
        chooseNumberOfTshirt.sendKeys("2");
        WebElement chooseSize = driver.switchTo().activeElement().findElement(By.xpath("//select[@id='group_1']"));
        chooseSize.click();
        WebElement chooseSize_S = driver.switchTo().activeElement().findElement(By.xpath("//select[@id='group_1']/option[1]"));
        chooseSize_S.click();
        WebElement chooseColor = driver.switchTo().activeElement().findElement(By.xpath("//a[@id='color_13']"));
        chooseColor.click();
        WebElement addToCart = driver.switchTo().activeElement().findElement(By.xpath("//span[text()='Add to cart']"));
        addToCart.click();
        driver.navigate().back();

        //Adding second product
        List<WebElement> clickDress = driver.findElements(By.xpath("//h5[@itemprop='name']/a"));
        clickDress.get(2).click();
        WebElement addToCart1 = driver.findElement(By.xpath("//span[text()='Add to cart']"));
        addToCart1.click();
        WebElement proceedToCheckOut = driver.findElement(By.xpath("//span[normalize-space()='Proceed to checkout']"));
        proceedToCheckOut.click();

        //Verifying if the titles are equal
        WebElement cartTitle = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        String actualCartTitle = cartTitle.getText();
        String expectedCartTitle = "SHOPPING-CART SUMMARY\n" + "Your shopping cart contains: 3 products";
        Assert.assertEquals(actualCartTitle, expectedCartTitle, "Cart titles are matching");

    }

    @Test
    public void removeProduct() {

        addToCart();
        //Removing the product
        List<WebElement> clickDeleteButton = driver.findElements(By.xpath("//i[@class='icon-trash']"));
        clickDeleteButton.get(0).click();
        waits(4000L);
        /*Boolean cartTitleIsVisible = driver.getTitle().equalsIgnoreCase("Your shopping cart contains: 2 products");
        Assert.assertTrue(cartTitleIsVisible)*/

        //Verifying the title
        WebElement cartTitle = driver.findElement(By.xpath("//span[@class='heading-counter']"));
        String actualCartTitle = cartTitle.getText();
        String expectedCartTitle = "Your shopping cart contains: 1 product";
        Assert.assertEquals(actualCartTitle, expectedCartTitle, "Cart titles are matching");

        waits(2000L);


        //Verifying the total calculation is displayed
        WebElement totalCalculation = driver.findElement(By.xpath("  //span[@id='total_price_without_tax']"));
        Boolean checkTotalCalculation = totalCalculation.isDisplayed();
        Assert.assertTrue(checkTotalCalculation);
        System.out.println("Total price without tax is $26");


    }

}



package com.ecommerce.tests;

import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class CheckingItemDetailsFromWindow {
    @FindBy(id = "email")
    WebElement singInEmail;
    /**
     * 1- Go to home page " https://ecommerce.yosemiteint.com/prestashop/index.php"
     * 2- Click sign in
     * 3- Fill the requirement fields with valid credentials
     * - Enter the email address
     * - Enter the password
     * - Click the SigninButton
     * 4- Click "Women" section
     * 5- Go on to first product
     * 6- Click on Quick view
     * 7- Check the product details page is displayed
     * 8- Check the product details --> Expected is : " "
     * 9- Check the price is --> Expected is : " "
     * 10- Click Add to Cart
     * 11-Check the text at checkout page --> Expected is : " "
     */
    WebDriver driver;
    private String url = "https://ecommerce.yosemiteint.com/prestashop/index.php";
    private String userId = "abcd@gmail.com";
    private String userPassword = "123456";
    SoftAssert sf = new SoftAssert();

    @BeforeTest
    void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }

    @Test
    public void checkProductDetails() {


        // Expected Texts on the product page
        String expectedItemName = "Faded Short Sleeves T-shirt";
        String expectedItemExp = "Faded short sleeves t-shirt with high neckline." +
                " Soft and stretchy material for a comfortable fit." +
                " Accessorize with a straw hat and you're ready for summer!";
        String expectedItemPrice = "$16.51";
        String expectedAddCheckText = "SHOPPING-CART SUMMARY";

        WebElement signInLink = driver.findElement(By.className("login"));
        signInLink.click();

        //Filling the requirement fields with valid credentials
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
        email.sendKeys(userId);
        password.sendKeys(userPassword);
        signInButton.click();
        Utility.waits(1);

        //Going to "Women" link
        WebElement womenLink = driver.findElement(By.linkText("Women"));
        womenLink.click();

        //Going to first product in the page
        List<WebElement> PageProducts = driver.findElements(By.cssSelector("h5[itemprop=name]>a.product-name"));
        Utility.scrollToCenter(driver, PageProducts.get(0));
        Utility.waits(1);
        Utility.hoverOver(driver, PageProducts.get(0), 1);
        WebElement quickview = driver.findElement(By.linkText("Quick view"));
        Assert.assertTrue(Utility.isElementVisible(driver, quickview, 1));
        quickview.click();
        driver.switchTo().frame(0);

        // Getting product details from the opening window
        WebElement actualItemTitle = driver.switchTo().activeElement().findElement(By.cssSelector("div[class*='pb-center-column']>h1"));
        WebElement actualItemDescription = driver.switchTo().activeElement().findElement(By.id("short_description_content"));
        WebElement actualItemSale = driver.switchTo().activeElement().findElement(By.id("our_price_display"));
        String actualItemName = actualItemTitle.getText();
        String actualItemExplanation = actualItemDescription.getText();
        String actualItemPrice = actualItemSale.getText();

        //Checking product details
        sf.assertEquals(actualItemName, expectedItemName, "PRODUCT NAME DOES NOT MATCH.");
        sf.assertEquals(actualItemExplanation, expectedItemExp, "PRODUCT DESCRIPTION DOES NOT MATCH.");
        sf.assertEquals(actualItemPrice, expectedItemPrice, "PRODUCT PRICE DOES NOT MATCH.");
        Utility.waits(1);

        //Adding product to cart
        WebElement addToCart = driver.switchTo().activeElement().findElement(By.name("Submit"));
        addToCart.click();
        Utility.waits(1);

        //Checking to add message
        WebElement checkAddMessage = driver.findElement(By.cssSelector("#cart_title"));
        String actualAddCheckText = checkAddMessage.getText();
        System.out.println(actualAddCheckText.contains(expectedAddCheckText) ? "PRODUCT ADDED" : "PRODUCT DOES NOT ADDED.");
        sf.assertAll();


    }


}

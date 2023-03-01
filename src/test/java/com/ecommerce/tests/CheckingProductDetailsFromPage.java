package com.ecommerce.tests;

import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;


public class CheckingProductDetailsFromPage {
    /**
     * 1- Go to home page " https://ecommerce.yosemiteint.com/prestashop/index.php"
     * 2- Click sign in
     * 3- Fill the requirement fields with valid credentials
     * - Enter the email address
     * - Enter the password
     * - Click the SigninButton
     * 4- Click "Women" section
     * 5-Click on first product
     * 6- Check the product details page is displayed
     * 7- Check the product details --> Expected is : " "
     * 8- Check the price is --> Expected is : " "
     * 9- Click Add to Cart
     * 10- Check the text at checkout page --> Expected is : " "
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
        String expectedAddCheckText = "Product successfully added to your shopping cart";
        String expectedItemPageTitle = "Faded Short Sleeves T-shirt - My Store";

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
        Utility.hoverOver(driver, PageProducts.get(0), 1);
        PageProducts.get(0).click();
        // Getting product details from the page
        WebElement actualItemTitle = driver.findElement(By.xpath("//h1[text()='Faded Short Sleeves T-shirt']"));
        WebElement actualItemDescription = driver.findElement(By.id("short_description_content"));
        WebElement actualItemSale = driver.findElement(By.id("our_price_display"));
        Utility.scrollToCenter(driver, actualItemDescription);
        String actualItemPageTitle = driver.getTitle();
        String actualItemName = actualItemTitle.getText();
        String actualItemExplanation = actualItemDescription.getText();
        String actualItemPrice = actualItemSale.getText();
        //Checking product details
        sf.assertEquals(actualItemPageTitle, expectedItemPageTitle, "PAGE TITLE DOES NOT MATCH");
        sf.assertEquals(actualItemName, expectedItemName, "PRODUCT NAME DOES NOT MATCH.");
        sf.assertEquals(actualItemExplanation, expectedItemExp, "PRODUCT DESCRIPTION DOES NOT MATCH.");
        sf.assertEquals(actualItemPrice, expectedItemPrice, "PRODUCT PRICE DOES NOT MATCH.");
        Utility.waits(1);
        //Adding product to cart
        WebElement addToCart = driver.findElement(By.name("Submit"));
        addToCart.click();
        //Checking to add message
        WebElement checkAddMessage = driver.findElement(By.cssSelector("div[class*='layer_cart_product col']>span.title"));
        String actualAddCheckText = checkAddMessage.getText();
        sf.assertEquals(actualAddCheckText, expectedAddCheckText, "PRODUCT DOES NOT ADDED.");
        sf.assertAll();
        Utility.waits(1);

    }
}

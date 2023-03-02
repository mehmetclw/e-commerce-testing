package com.ecommerce.tests;

import com.ecommerce.pages.ItemDetailsVerificationPages;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class ItemDetailsVerificationTest {
    /** @Test pageDetailsVerif()
     * 1- Go to home page " https://ecommerce.yosemiteint.com/prestashop/index.php"
     * 2- Click sign in
     * 3- Fill the requirement fields with valid credentials
     *      - Enter the email address
     *       - Enter the password
     *         - Click the Signin Button
     * 4- Click "Women" section
     * 5- Click on first product
     * 6- Check the product details page is displayed
     * 7- Check the product details --> Expected is : " "
     * 8- Check the price is --> Expected is : " "
     * 9- Click Add to Cart
     * 10- Check the text at checkout page --> Expected is : " "
     */
    /**
     * @Test windowDetailsVerif()
     * 1- Go to home page " https://ecommerce.yosemiteint.com/prestashop/index.php"
     * 2- Click sign in
     * 3- Fill the requirement fields with valid credentials
     * - Enter the email address
     * - Enter the password
     * - Click the Signin Button
     * 4- Click "Women" section
     * 5- Go on to first product
     * 6- Click on Quick view
     * 7- Check the product details page is displayed
     * 8- Check the product details --> Expected is : " "
     * 9- Check the price is --> Expected is : " "
     * 10- Click Add to Cart
     * 11-Check the text at checkout page --> Expected is : " "
     */
    String url = ConfigReader.getProperty("url");
    WebDriver driver;
    ItemDetailsVerificationPages idv;
    SoftAssert sf = new SoftAssert();

    @BeforeMethod
    void browserSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        idv = new ItemDetailsVerificationPages(driver);
        idv.setup();

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

    @Test
    public void pageDetailsVerif() {
        idv.pageDetailsVerif();
    }

    @Test
    public void windowDetailsVerif() {
        idv.windowDetailsVerif();
    }
}

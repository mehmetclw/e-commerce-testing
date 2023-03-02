package com.ecommerce.tests;

import com.ecommerce.utility.Database;
import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchFunctionalityTest {
    /**
     * Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
     * Verify you are in home page / Expected title="My Store"
     * Click on search button type "Dress"
     * click search
     * verify the search page id displayed
     * check all the expected result to be Dress items
     * 1- product name have Dress
     * 2-image related to dress
     */
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://ecommerce.yosemiteint.com/prestashop/index.php");
    }
    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
    @Test
    public void validSearching() {

        //* Verify you are in home page / Expected title="My Store"
        String expectedPageTitle = "My Store";
        // Get the title of the web page and compare to expected title
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, expectedPageTitle, "Page title not match");
        System.out.println("The user in the home page");
        //Go to search button and Enter "Dress" and click search
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("Dress");
        WebElement searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();
        //verify the search page id displayed
        String expectedSearchPageTitle = "Search - My Store";
        String searchPageTitle = driver.getTitle();
        Assert.assertEquals(searchPageTitle, expectedSearchPageTitle, "Search page not displayed");
        System.out.println("the user is in searching page ");
        Utility.waits(3);
        WebElement element=driver.findElement(By.xpath("(//a[contains(text(),'Printed Summer Dress')])[2]"));
        Utility.hoverOver(driver,element,3);
        scrollDown(driver);
        Utility.waits(3);
        scrollUp(driver);
        // Verify that relevant search results are displayed
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id=\"product_list\"]"));
        for (WebElement searchResult : searchResults) {
            String productTitle = searchResult.findElement(By.cssSelector("h5>a")).getText();
            if (!productTitle.contains("Dress")) {
                System.out.println("Error: Invalid search result - " + productTitle);
            }
            else {
                System.out.println("Relevant search result ");
            }}


    }
}

package com.ecommerce.tests;

import com.ecommerce.utility.library.AppLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {
    WebDriver driver;
    private AppLibrary appLibrary;
    @BeforeMethod
    public void browserSetup() {
        driver = WebDriverManager.chromedriver().create();
        //driver = WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        appLibrary = new AppLibrary(driver);
    }

    public AppLibrary getAppLibrary() {
        return appLibrary;
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

}

package com.ecommerce.tests;

import com.ecommerce.utility.Driver;
import com.ecommerce.utility.library.AppLibrary;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    private AppLibrary appLibrary;
    @BeforeMethod
    public void browserSetup() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        appLibrary = new AppLibrary();
    }

    public AppLibrary getAppLibrary() {
        return appLibrary;
    }

    @AfterMethod
    void tearDown() {
        Driver.close();
    }

}

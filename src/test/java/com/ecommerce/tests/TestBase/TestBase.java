package com.ecommerce.tests.TestBase;

import com.ecommerce.utility.Driver;
import com.ecommerce.utility.library.AppLibrary;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestBase {
    private AppLibrary appLibrary;

    @BeforeMethod(alwaysRun = true, groups = {"smoke", "regression"},
            onlyForGroups = {"smoke", "regression"})
    synchronized public void browserSetup() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        appLibrary = new AppLibrary();
    }

    @BeforeMethod(onlyForGroups = {"data"}, alwaysRun = true)
    synchronized public void dataLoad() {
        System.out.println("Data Loading started");
        List<String> data = new ArrayList<>();
    }

    @BeforeMethod(onlyForGroups = {"dbConnection", "db"}, alwaysRun = true)
    synchronized public void dataconnection() {
        System.out.println("Database connection started");

    }

    public AppLibrary getAppLibrary() {
        return appLibrary;
    }

    @AfterMethod(alwaysRun = true)
    synchronized void tearDown() {
        Driver.close();
    }

}

package com.ecommerce.tests;

import com.ecommerce.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestingTestNGAnnotationsTest {
    WebDriver driver;
    SoftAssert sf = new SoftAssert();

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://ecommerce.yosemiteint.com/prestashop/index.php");
    }

    @Test(description = "EC-40 | Login functionality testing")
    @Parameters({"browser", "userName"})
    public void parameterTest(String browser, String userName) {
        System.out.println("userName = " + userName);
        System.out.println("browser = " + browser);
        Utility.waits(4);
    }

    @Test(dependsOnMethods = {"test5"},
            groups = {"smoke", "regression"},
            description = "EC-37 / Search functionality testing to verify search works properly"
    )
    public void test1() {
        System.out.println("This is test1");
        Utility.waits(4);
    }

    @Test(dependsOnMethods = {"test6"})
    @Parameters({"email", "password"})
    public void test2(String email, String password) {
        System.out.println("This is test2");
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        Utility.waits(4);
    }

    @Test(groups = "smoke")
    public void test3() {
        System.out.println("This is test3");
        Utility.waits(4);
    }

    @Test(groups = "regression", dependsOnGroups = {})
    public void test4() {
        System.out.println("This is test4");
        Utility.waits(4);
    }

    @Test
    public void test5() {
        System.out.println("This is test5");
        Utility.waits(4);
    }

    @Test
    public void test6() {
        System.out.println("This is test6");
        Utility.waits(4);
    }
}

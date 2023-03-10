package com.ecommerce.tests.UI.frontend;

import com.ecommerce.tests.TestBase.TestBase;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Utility;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestingTestNGAnnotationsTest extends TestBase {

    public String url = ConfigReader.getProperty("url");

    @Test(groups = {"regression"},description = "EC-40 | Login functionality testing")
    @Parameters({"browser", "userName"})
    public void parameterTest(@Optional String browser, @Optional String userName) {
        if (browser != null && userName != null) {
            System.out.println("userName = " + userName);
            System.out.println("browser = " + browser);
        }else
            System.out.println("User Name and/or Browser is null");
        Utility.waits(4);
    }

    @Test(groups = {"smoke", "regression"},
            description = "EC-37 / Search functionality testing to verify search works properly"
    )
    public void test1() {
        System.out.println("This is test1");
        Utility.waits(4);
    }

    @Test( groups = {"smoke", "regression"})
    @Parameters({"email", "password"})
    public void test2(@Optional String email, @Optional String password) {
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

    @Test(groups = "regression")
    public void test4() {
        System.out.println("This is test4");
        Utility.waits(4);
    }

    @Test(groups = {"smoke", "regression"})
    public void test5() {
        System.out.println("This is test5");
        Utility.waits(4);
    }

    @Test(groups = {"smoke", "regression"})
    public void test6() {
        System.out.println("This is test6");
        Utility.waits(4);
    }
}

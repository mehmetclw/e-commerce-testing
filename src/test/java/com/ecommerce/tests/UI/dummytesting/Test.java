package com.ecommerce.tests.UI.dummytesting;

import com.ecommerce.tests.TestBase.TestBase;

public class Test extends TestBase {

    @org.testng.annotations.Test(groups = "smoke")
    public void testBeforeMethod(){
        System.out.println("This is checking for DB before method");
    }

    @org.testng.annotations.Test(groups = "data")
    public void testBeforeMethod1(){
        System.out.println("This is checking for DB before method");
    }
}

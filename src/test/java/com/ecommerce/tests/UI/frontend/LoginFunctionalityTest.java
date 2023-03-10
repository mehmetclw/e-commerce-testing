package com.ecommerce.tests.UI.frontend;

import com.ecommerce.tests.TestBase.TestBase;
import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.Test;


public class LoginFunctionalityTest extends TestBase {
    public String url = ConfigReader.getProperty("url");

    @Test(groups = {"smoke", "regression"},
    description = "EC-2 UI | Test the login functionality")
    public void loginFunctionalityTest()  {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getLoginFunctionalityPage().loginFunctionalityTest();
    }
}

package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.Test;

public class TestShippingOptionsTest extends TestBase {

    public String url = ConfigReader.getProperty("url");
    public String email = ConfigReader.getProperty("emailAddress");

    @Test(groups = {"smoke","regression"}) //EC-25, EC-26,EC-35, EC-45
    public void testAvailableShippingOptions(){
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getTsop().testAvailableShippingOptions();
    }
}

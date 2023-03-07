package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.Test;

public class TestShippingOptionsTest extends TestBase {

    public String url = ConfigReader.getProperty("url");
    public String email = ConfigReader.getProperty("emailAddress");
    public String passwordKey = ConfigReader.getProperty("passwordKey");
    @Test
    public void testAvailableShippingOptions(){

        getAppLibrary().getFlowsLibrary().navigateToUrl(url);

        getAppLibrary().getPage().getTsop().testAvailableShippingOptions();


    }



}

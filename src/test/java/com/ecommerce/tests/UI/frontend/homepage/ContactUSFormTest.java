package com.ecommerce.tests.UI.frontend.homepage;

import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.Test;

public class ContactUSFormTest extends TestBase{
   String url = ConfigReader.getProperty("url");
   @Test
    public void contactUsFormTest(){
       getAppLibrary().getFlowsLibrary().navigateToUrl(url);
       getAppLibrary().getPage().getCufp().contactUSFormMethod();


   }

}





















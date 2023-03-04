package com.ecommerce.utility.library;

import org.openqa.selenium.WebDriver;

public class FlowsLibrary {

    WebDriver driver;

    public FlowsLibrary(WebDriver driver){
        this.driver=driver;
    }

    public void navigateToUrl(String url){
        this.driver.get(url);
    }

    public String getCurrentPageTitle(){
       return this.driver.getTitle();
    }

    public String getCurrentPageUrl(){
        return this.driver.getCurrentUrl();
    }
}

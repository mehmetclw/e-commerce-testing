package com.ecommerce.utility.library;

import org.openqa.selenium.WebDriver;

public class AppLibrary {
    private WebDriver driver;
    private PageLibrary page;
    private FlowsLibrary flowsLibrary;

    public AppLibrary(WebDriver driver) {
        this.driver = driver;
        page = new PageLibrary(this.driver);
        flowsLibrary = new FlowsLibrary(this.driver);
    }

    public PageLibrary getPage() {
        return page;
    }

    public FlowsLibrary getFlowsLibrary() {
        return flowsLibrary;
    }
}

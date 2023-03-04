package com.ecommerce.utility.library;

import com.ecommerce.pages.*;
import org.openqa.selenium.WebDriver;

public class PageLibrary {
    private WebDriver driver;
    private UserRegistrationPages urp;

    public TestTheNavigationPages tnp;
    private ShoppingCartPages scp;
    private SearchFunctionalityPages sfp;
    private ItemDetailsVerificationPages idv;
    private UserRegistrationNewPages urnp;

    public PageLibrary(WebDriver driver) {
        this.driver = driver;
        urp = new UserRegistrationPages(this.driver);
        tnp = new TestTheNavigationPages(this.driver);
        scp = new ShoppingCartPages(this.driver);
        sfp = new SearchFunctionalityPages(this.driver);
        idv = new ItemDetailsVerificationPages(this.driver);
        urnp =new UserRegistrationNewPages(this.driver);
    }

    public UserRegistrationPages getUrp() {
        return urp;
    }

    public TestTheNavigationPages getTnp() {
        return tnp;
    }

    public ShoppingCartPages getScp() {
        return scp;
    }

    public SearchFunctionalityPages getSfp() {
        return sfp;
    }

    public ItemDetailsVerificationPages getIdv() {
        return idv;
    }

    public UserRegistrationNewPages getUrnp() {
        return urnp;
    }
}

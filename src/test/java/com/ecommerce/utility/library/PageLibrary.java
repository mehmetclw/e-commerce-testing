package com.ecommerce.utility.library;

import com.ecommerce.pages.*;
import com.ecommerce.tests.FootlinksTest;
import com.ecommerce.utility.Driver;
import org.openqa.selenium.WebDriver;

public class PageLibrary {
    private UserRegistrationPages urp;

    public TestTheNavigationPages tnp;
    private ShoppingCartPages scp;
    private SearchFunctionalityPages sfp;
    private ItemDetailsVerificationPages idv;
    private UserRegistrationNewPages urnp;
    private TestShippingOptionsPages tsop;
    private AccountManagementFunctionalityPages amfp;
    private HomePage hPage;
    private LoginFunctionalityPage loginFunctionalityPage;
    private FootLinksPages flp;

    private SubmissionOfFormPage sofp;

    public PageLibrary() {
        urp = new UserRegistrationPages();
        tnp = new TestTheNavigationPages();
        scp = new ShoppingCartPages();
        sfp = new SearchFunctionalityPages();
        idv = new ItemDetailsVerificationPages();
        urnp = new UserRegistrationNewPages();
        tsop = new TestShippingOptionsPages();
        amfp = new AccountManagementFunctionalityPages();
        hPage=new HomePage();
        loginFunctionalityPage=new LoginFunctionalityPage();
        flp= new FootLinksPages();
        sofp=new SubmissionOfFormPage();
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

    public TestShippingOptionsPages getTsop() {
        return tsop;
    }

    public AccountManagementFunctionalityPages getAmfp() {
        return amfp;
    }

    public HomePage getHPage() {
        return hPage;
    }

    public LoginFunctionalityPage getLoginFunctionalityPage() {
        return loginFunctionalityPage;
    }
    public FootLinksPages getFlp(){return flp;}

    public SubmissionOfFormPage getSofp(){return sofp;}
    }




package com.ecommerce.utility.library;


import com.ecommerce.pages.frontend.LoginFunctionalityPage;
import com.ecommerce.pages.frontend.SubmissionOfFormPage;
import com.ecommerce.pages.frontend.TestShippingOptionsPages;
import com.ecommerce.pages.frontend.TestTheNavigationPages;
import com.ecommerce.pages.frontend.customeraccounts.AccountManagementFunctionalityPages;
import com.ecommerce.pages.frontend.homepage.FooterLinksPages;
import com.ecommerce.pages.frontend.homepage.HomePage;
import com.ecommerce.pages.frontend.homepage.NewsletterFunctionalityPage;
import com.ecommerce.pages.frontend.homepage.SearchFunctionalityPages;
import com.ecommerce.pages.frontend.products.ItemDetailsVerificationPages;
import com.ecommerce.pages.frontend.registration.UserRegistrationNewPages;
import com.ecommerce.pages.frontend.registration.UserRegistrationPages;
import com.ecommerce.pages.frontend.shoppingcart.ShoppingCartPages;
import com.ecommerce.pages.frontend.shoppingcart.ShoppingCartProductQuantityPages;

public class PageLibrary {
    private UserRegistrationPages urp;

    private TestTheNavigationPages tnp;
    private ShoppingCartPages scp;
    private SearchFunctionalityPages sfp;
    private ItemDetailsVerificationPages idv;
    private UserRegistrationNewPages urnp;
    private TestShippingOptionsPages tsop;
    private AccountManagementFunctionalityPages amfp;
    private HomePage hPage;
    private LoginFunctionalityPage loginFunctionalityPage;
    private FooterLinksPages flp;
    private NewsletterFunctionalityPage nfp;
    private SubmissionOfFormPage sofp;
    private ShoppingCartProductQuantityPages scpqp;

    private ContactUSFormPage cufp;
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
        flp= new FooterLinksPages();
        nfp = new NewsletterFunctionalityPage();
        sofp = new SubmissionOfFormPage();
        scpqp= new ShoppingCartProductQuantityPages();
        cufp= new ContactUSFormPage();
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
    public FooterLinksPages getFlp(){return flp;}
    public NewsletterFunctionalityPage getNfp(){return nfp;}
    public SubmissionOfFormPage getSofp(){return sofp;}
    public ShoppingCartProductQuantityPages getScpqp(){return scpqp;}

    public ContactUSFormPage getCufp(){return cufp;}
    }




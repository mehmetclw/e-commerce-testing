package com.ecommerce.tests.UI.frontend.homepage;

import com.ecommerce.tests.TestBase.TestBase;
import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.Test;

public class NewsletterFunctionalityTest extends TestBase {
    /**
     * @Test Newsletter Function from home page
     * 1- Go to home page " https://ecommerce.yosemiteint.com/prestashop/index.php"
     * 2- Scroll down the screen
     * 3- Fill the requirement fields with valid credentials
     * - Newsletter bar enter your e-mail
     * 4- Go to e-mail account provider website
     * 5- Check the inbox for confirmation e-mail.
     */

    String url = ConfigReader.getProperty("url");
    String fakeProvider = ConfigReader.getProperty("fakeEmailProvider");

    @Test
    public void homePageNewsletterFunc() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getNfp().homePageNewsletterFunc();
        getAppLibrary().getPage().getNfp().verifyInbox(fakeProvider);
    }

    @Test
    public void signUpNewsletterFunc() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getNfp().signUpNewsletterFunc();
        getAppLibrary().getPage().getNfp().verifyInboxSignup(fakeProvider);
    }

    @Test
    public void changeSetNewsletterFunc() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getNfp().changeSetNewsletterFunc();
        getAppLibrary().getPage().getNfp().verifyInboxSettings(fakeProvider);
        getAppLibrary().getPage().getNfp().uncheckNewsletterBox();

    }

}

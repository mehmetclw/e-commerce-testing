package com.ecommerce.pages;

import com.ecommerce.elements.FootLinksElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FootLinksPages extends Utility {
    SoftAssert sf = new SoftAssert();
    FootLinksElements fle;

    public void checkCategoriesLink() {
        fle = new FootLinksElements();
        scrollTo(fle.womenLink);
        waits(2);
        clickElement(fle.womenLink);
        waits(2);
        sf.assertTrue(fle.womenLinkPageHeader.isDisplayed());
    }

    public void checkInformationLinks() {
        fle = new FootLinksElements();
        scrollToCenter(fle.specialLink);
        waits(2);
        clickElement(fle.specialLink);
        waits(2);
        sf.assertTrue(fle.specialLinkPageHeader.isDisplayed());

        scrollTo(fle.newProductsLink);
        waits(1);
        clickElement(fle.newProductsLink);
        waits(2);
        String actualUrl = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=new-products";
        String expectedUrl = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl, actualUrl, "NOT MATCHED");

        scrollTo(fle.bestSellersLink);
        waits(1);
        fle.bestSellersLink.click();
        waits(2);
        String actualUrl1 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=best-sales";
        String expectedUrl1 = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl1, actualUrl1, "NOT MATCHED");

        scrollTo(fle.ourStores);
        clickElement(fle.ourStores);
        String actualUrl2 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=stores";
        String expectedUrl2 = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl2, actualUrl2, "NOT MATCHED");

        scrollTo(fle.contactUs);
        clickElement(fle.contactUs);
        String actualUrl3 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=contact";
        String expectedUrl3 = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl3, actualUrl3, "NOT MATCHED");

        scrollTo(fle.termsAndConditions);
        clickElement(fle.termsAndConditions);
        String actualUrl4 = "https://ecommerce.yosemiteint.com/prestashop/index.php?id_cms=3&controller=cms";
        String expectedUrl4 = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl4, actualUrl4, "NOT MATCHED");

        scrollTo(fle.aboutUs);
        clickElement(fle.aboutUs);
        String actualUrl5 = "https://ecommerce.yosemiteint.com/prestashop/index.php?id_cms=4&controller=cms";
        String expectedUrl5 = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl5, actualUrl5, "NOT MATCHED");
        waits(2);

        scrollTo(fle.sitemap);
        clickElement(fle.sitemap);
        String actualUrl6 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=sitemap";
        String expectedUrl6 = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl6, actualUrl6, "NOT MATCHED");
        waits(2);
    }
    public void myAccountLinks() {
        fle = new FootLinksElements();
        scrollTo(fle.myOrders);
        clickElement(fle.myOrders);
        String actualUrl = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=authentication&back=history";
        String expectedUrl = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl, actualUrl, "NOT MATCHED");
        waits(1);

        scrollTo(fle.myCreditSlips);
        clickElement(fle.myCreditSlips);
        String actualUrl1 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=authentication&back=order-slip";
        String expectedUrl1 = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl1, actualUrl1, "NOT MATCHED");
        waits(1);

        scrollTo(fle.myAddresses);
        clickElement(fle.myAddresses);
        String actualUrl2 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=authentication&back=addresses";
        String expectedUrl2 = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl2, actualUrl2, "NOT MATCHED");
        waits(1);

        scrollTo(fle.myPersonalInfo);
        clickElement(fle.myPersonalInfo);
        String actualUrl3 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=authentication&back=identity";
        String expectedUrl3 = Driver.getDriver().getCurrentUrl();
        sf.assertEquals(expectedUrl3, actualUrl3, "NOT MATCHED");
        waits(1);
    }
}



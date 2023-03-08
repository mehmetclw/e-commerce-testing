package com.ecommerce.pages;

import com.ecommerce.elements.FootLinksElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.testng.Assert;

public class FootLinksPages extends Utility {

    FootLinksElements fle;

    public void checkCategoriesLink() {
        fle = new FootLinksElements();
        scrollTo(fle.womenLink);
        waits(2);
        fle.womenLink.click();
        waits(2);
        Assert.assertTrue(fle.womenLinkPageHeader.isDisplayed());
    }

    public void checkInformationLinks() {
        fle = new FootLinksElements();
        scrollToCenter(fle.specialLink);
        waits(2);
        fle.specialLink.click();
        waits(2);
        Assert.assertTrue(fle.specialLinkPageHeader.isDisplayed());

        scrollTo(fle.newProductsLink);
        waits(1);
        fle.newProductsLink.click();
        waits(2);
        String actualUrl = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=new-products";
        String expectedUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "NOT MATCHED");

        scrollTo(fle.bestSellersLink);
        waits(1);
        fle.bestSellersLink.click();
        waits(2);
        String actualUrl1 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=best-sales";
        String expectedUrl1 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl1, actualUrl1, "NOT MATCHED");

        scrollTo(fle.ourStores);
        fle.ourStores.click();
        String actualUrl2 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=stores";
        String expectedUrl2 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl2, actualUrl2, "NOT MATCHED");

        scrollTo(fle.contactUs);
        fle.contactUs.click();
        String actualUrl3 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=contact";
        String expectedUrl3 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl3, actualUrl3, "NOT MATCHED");

        scrollTo(fle.termsAndConditions);
        fle.termsAndConditions.click();
        String actualUrl4 = "https://ecommerce.yosemiteint.com/prestashop/index.php?id_cms=3&controller=cms";
        String expectedUrl4 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl4, actualUrl4, "NOT MATCHED");

        scrollTo(fle.aboutUs);
        fle.aboutUs.click();
        String actualUrl5 = "https://ecommerce.yosemiteint.com/prestashop/index.php?id_cms=4&controller=cms";
        String expectedUrl5 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl5, actualUrl5, "NOT MATCHED");
        waits(2);

        scrollTo(fle.sitemap);
        fle.sitemap.click();
        String actualUrl6 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=sitemap";
        String expectedUrl6 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl6, actualUrl6, "NOT MATCHED");
        waits(2);
    }
    public void myAccountLinks() {
        fle = new FootLinksElements();
        scrollTo(fle.myOrders);
        fle.myOrders.click();
        String actualUrl = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=authentication&back=history";
        String expectedUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "NOT MATCHED");
        waits(1);

        scrollTo(fle.myCreditSlips);
        fle.myCreditSlips.click();
        String actualUrl1 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=authentication&back=order-slip";
        String expectedUrl1 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl1, actualUrl1, "NOT MATCHED");
        waits(1);

        scrollTo(fle.myAddresses);
        fle.myAddresses.click();
        String actualUrl2 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=authentication&back=addresses";
        String expectedUrl2 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl2, actualUrl2, "NOT MATCHED");
        waits(1);

        Utility.scrollTo(fle.myPersonalInfo);
        fle.myPersonalInfo.click();
        String actualUrl3 = "https://ecommerce.yosemiteint.com/prestashop/index.php?controller=authentication&back=identity";
        String expectedUrl3 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl3, actualUrl3, "NOT MATCHED");
        waits(1);
    }
}



package com.ecommerce.pages;

import com.ecommerce.elements.FootLinksElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FootLinksPages extends Utility {
    SoftAssert sf = new SoftAssert();
    FootLinksElements fle;

    public FootLinksPages() {
        fle = new FootLinksElements();
    }

    public void checkCategoriesLink() {
      /* All test same tab :
        scrollTo(fle.womenLink);
        waits(2);
        clickElement(fle.womenLink);
        waits(2);
        sf.assertTrue(fle.womenLinkPageHeader.isDisplayed());

       */
        Driver.getDriver().navigate();

        String parentId = Driver.getDriver().getWindowHandle();
        System.out.println("parentId = " + parentId);
        List<WebElement> urls = Driver.getDriver().findElements(By.xpath("//footer//a[contains(@title,'')][normalize-space()='Women']"));

        Actions a = new Actions(Driver.getDriver());
        for (WebElement url : urls) {
            //a.moveToElement(url).keyDown(Keys.CONTROL).click().build().perform(); //For windows users
            a.moveToElement(url).keyDown(Keys.COMMAND).click().build().perform();
        }
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        System.out.println("allWindows = " + allWindows);

        //Using iteration to switch between windows
        Iterator<String> window = allWindows.iterator();
        String parent = window.next();
        while (window.hasNext()) {
            String child = window.next();
            Driver.getDriver().switchTo().window(child);
            System.out.println("driver.getTitle() = " + Driver.getDriver().getTitle());
            System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
            waits(5);
            Driver.getDriver().close(); //For closing the current tab use driver.close()
        }
        Driver.getDriver().switchTo().window(parent);

        //Another way of iterating the windows
      /*  List<String> windows = new ArrayList<>(allWindows);
        for (int i = 1; i <windows.size() ; i++) {
            driver.switchTo().window(windows.get(i));
            System.out.println("driver.getTitle() = " + driver.getTitle());
             System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
            Thread.sleep(1000);
        }*/

        waits(5);
    }

    public void checkInformationLinks() {
        /*
        All test same tab:
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

         */

        Driver.getDriver().navigate();

        String parentId = Driver.getDriver().getWindowHandle();
        System.out.println("parentId = " + parentId);

        List<WebElement> urls = Driver.getDriver().findElements(By.xpath("//section[@id='block_various_links_footer']//a[contains(@title,'Specials')]"));
        urls.add(Driver.getDriver().findElement(By.xpath("//section[@id='block_various_links_footer']//a[contains(@title,'New products')]")));
        urls.add(Driver.getDriver().findElement(By.xpath("//a[normalize-space()='Best sellers']")));
        urls.add(Driver.getDriver().findElement(By.xpath("(//a[normalize-space()='Our stores'])[1]")));
        urls.add(Driver.getDriver().findElement(By.xpath("(//a[@title='Contact us'])[2]")));
        urls.add(Driver.getDriver().findElement(By.xpath("//a[@title='Terms and conditions of use']")));
        urls.add(Driver.getDriver().findElement(By.xpath("//a[@title='About us']")));
        urls.add(Driver.getDriver().findElement(By.xpath("//a[@title='Sitemap']")));


        // clickElement(fle.infoLinks.get(0));

        Actions a = new Actions(Driver.getDriver());
        for (WebElement url : urls) {
            //a.moveToElement(url).keyDown(Keys.CONTROL).click().build().perform(); //For windows users
            a.moveToElement(url).keyDown(Keys.COMMAND).click().build().perform();
        }
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        System.out.println("allWindows = " + allWindows);

        //Using iteration to switch between windows
        Iterator<String> window = allWindows.iterator();
        String parent = window.next();
        while (window.hasNext()) {
            String child = window.next();
            Driver.getDriver().switchTo().window(child);
            System.out.println("driver.getTitle() = " + Driver.getDriver().getTitle());
            System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
            waits(5);
            Driver.getDriver().close(); //For closing the current tab use driver.close()
        }
        Driver.getDriver().switchTo().window(parent);
        waits(4);

    }

    public void myAccountLinks() {
        /*
        All test same tab:
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

         */
        Driver.getDriver().navigate();

        String parentId = Driver.getDriver().getWindowHandle();
        System.out.println("parentId = " + parentId);

        List<WebElement> urls = Driver.getDriver().findElements(By.xpath("//a[@title='My orders']"));
        urls.add(Driver.getDriver().findElement(By.xpath("(//a[@title='My credit slips'])[1]")));
        urls.add(Driver.getDriver().findElement(By.xpath("//a[@title='My addresses']")));
        urls.add(Driver.getDriver().findElement(By.xpath("//a[@title='Manage my personal information']")));

        Actions a = new Actions(Driver.getDriver());
        for (WebElement url : urls) {
            //a.moveToElement(url).keyDown(Keys.CONTROL).click().build().perform(); //For windows users
            a.moveToElement(url).keyDown(Keys.COMMAND).click().build().perform();
        }
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        System.out.println("allWindows = " + allWindows);

        //Using iteration to switch between windows
        Iterator<String> window = allWindows.iterator();
        String parent = window.next();
        while (window.hasNext()) {
            String child = window.next();
            Driver.getDriver().switchTo().window(child);
            System.out.println("driver.getTitle() = " + Driver.getDriver().getTitle());
            System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
            waits(5);
            Driver.getDriver().close(); //For closing the current tab use driver.close()
        }
        Driver.getDriver().switchTo().window(parent);
        waits(4);
    }


}





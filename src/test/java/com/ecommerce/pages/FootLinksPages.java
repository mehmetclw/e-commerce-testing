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





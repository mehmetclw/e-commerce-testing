package com.ecommerce.pages;

import com.ecommerce.elements.NewsletterFunctionalityElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import java.util.Iterator;
import java.util.Set;

public class NewsletterFunctionalityPage extends Utility {

    NewsletterFunctionalityElements nfe = new NewsletterFunctionalityElements();
    public String newsletterEmail1 = ConfigReader.getProperty("newsletterEmail1");
    public String newsletterEmail2 = ConfigReader.getProperty("newsletterEmail2");
    public String fakeEmail = ConfigReader.getProperty("fakeEmail");
    public String fakeRegEmail = ConfigReader.getProperty("fakeRegEmail");
    public String confMessage = ConfigReader.getProperty("newsletterConFMessage");
    public String password = ConfigReader.getProperty("userPasswordEC-4");

    public void homePageNewsletterFunc() {

        scrollTo(nfe.newsletterBar);
        sendKeyToElement(nfe.newsletterBar, newsletterEmail1);
        clickElement(nfe.newsletterButton);
        waits(2);

    }

    public void signUpNewsletterFunc() {
        clickElement(nfe.signInLink);
        sendKeyToElement(nfe.emailAddress, newsletterEmail1);
        clickElement(nfe.createAccountButton);
        clickElement(nfe.mrsCheckBox);
        sendKeyToElement(nfe.firstName, fakeEmail);
        sendKeyToElement(nfe.lastName, fakeEmail);
        sendKeyToElement(nfe.password, password);
        clickElement(nfe.newsletterBox);
        clickElement(nfe.register);
        waits(2);
    }

    public void changeSetNewsletterFunc(){
        clickElement(nfe.signInLink);
        sendKeyToElement(nfe.email,newsletterEmail2);
        sendKeyToElement(nfe.password,password);
        clickElement(nfe.signInButton);
        scrollToCenter(nfe.myPersonalInfoButton.get(4));
        clickElement(nfe.myPersonalInfoButton.get(4));
        scrollToCenter(nfe.newsletterBox);
        sendKeyToElement(nfe.oldPasswd,password);
        sendKeyToElement(nfe.password,password);
        sendKeyToElement(nfe.confirmNewPasswd,password);
        nfe.newsletterBox.click();
        clickElement(nfe.saveButton);
        waits(1);
    }
    public void uncheckNewsletterBox(){
        clickElement(nfe.backToAccount.get(0));
        scrollToCenter(nfe.myPersonalInfoButton.get(4));
        clickElement(nfe.myPersonalInfoButton.get(4));
        scrollToCenter(nfe.newsletterBox);
        sendKeyToElement(nfe.oldPasswd,password);
        sendKeyToElement(nfe.password,password);
        sendKeyToElement(nfe.confirmNewPasswd,password);
        nfe.newsletterBox.click();
        clickElement(nfe.saveButton);
        waits(1);
    }
    public void verifyInbox(String url) {
        /*
 @Test
    public void test() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        waits(3);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open()");
        Set<String> windows = Driver.getDriver().getWindowHandles();
        int count = 0;
        for (String win : windows) {   //  [52C399D5A8EE3CBA1A042EC8109F7062, 11E403379417F9F11E9BB59B75924B57]
            waits(1);
            if (count > 0) {
                Driver.getDriver().switchTo().window(win);
                getAppLibrary().getFlowsLibrary().navigateToUrl(url);
                waits(3);
            }
            count++;
        }
        waits(5);
    }*/
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open()");
        String mainWindow = Driver.getDriver().getWindowHandle();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            String childWindow = it.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                Driver.getDriver().switchTo().window(childWindow);
                Driver.getDriver().navigate().to(url);
            }
        }
        sendKeyToElement(nfe.fakeEmail, fakeEmail);
        waits(1);
        selectElementByValue(nfe.fakeSelector, "trash-mail.com---0");
        waits(1);
        clickElement(nfe.fetchButton);
        String confirmEmail = getTextElement(nfe.tablerow.get(0)) + " " + getTextElement(nfe.tablerow.get(1));
        Assert.assertTrue(confirmEmail.contains(confMessage), "Message does not match.");
        waits(1);
    }
    public void verifyInboxSignup(String url) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open()");
        String mainWindow = Driver.getDriver().getWindowHandle();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            String childWindow = it.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                Driver.getDriver().switchTo().window(childWindow);
                Driver.getDriver().navigate().to(url);
            }
        }
        sendKeyToElement(nfe.fakeEmail, fakeEmail);
        waits(1);
        selectElementByValue(nfe.fakeSelector, "trash-mail.com---0");
        waits(1);
        clickElement(nfe.fetchButton);
        String confirmEmail = getTextElement(nfe.tablerow.get(0)) + " " + getTextElement(nfe.tablerow.get(1));
        Assert.assertTrue(confirmEmail.contains(confMessage), "Message does not match.");
        waits(1);
    }
    public void verifyInboxSettings(String url) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open()");
        String mainWindow = Driver.getDriver().getWindowHandle();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            String childWindow = it.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                Driver.getDriver().switchTo().window(childWindow);
                Driver.getDriver().navigate().to(url);
            }
        }
        sendKeyToElement(nfe.fakeEmail, fakeRegEmail);
        waits(1);
        selectElementByValue(nfe.fakeSelector, "trash-mail.com---0");
        waits(1);
        clickElement(nfe.fetchButton);
        String confirmEmail = getTextElement(nfe.tablerow.get(0));
        Assert.assertTrue(confirmEmail.contains(confMessage), "Message does not match.");
        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(mainWindow);
        waits(1);
    }
}

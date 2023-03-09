package com.ecommerce.pages;

import com.ecommerce.elements.SubmissionOfFormElement;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.Utility;
import org.testng.Assert;

public class SubmissionOfFormPage extends Utility {

    public SubmissionOfFormElement sofe;

    public SubmissionOfFormPage() {
        sofe = new SubmissionOfFormElement();
    }

    public String email = ConfigReader.getProperty("emailAddress1");
    public String password = ConfigReader.getProperty("password");
    public String email1 = ConfigReader.getProperty("emailAdmin");
    public String password1 = ConfigReader.getProperty("passwordAdmin");


    public void submitForm() {
        clickElement(sofe.clickOnSignIn);
        clickElement(sofe.enterEmail);
        clearElement(sofe.enterEmail);
        sendKeyToElement(sofe.enterEmail, ConfigReader.getProperty("emailAddress1"));
        clickElement(sofe.enterPassword);
        sendKeyToElement(sofe.enterPassword,ConfigReader.getProperty("password"));
        clickElement(sofe.signInButton1);
        clickElement(sofe.contactUs);
        selectElementByValue(sofe.chooseCustomerService,"2");
        selectElementByIndex(sofe.chooseOrderReference,1);
        selectElementByIndex(sofe.chooseTshirt,1);
        clickElement(sofe.messages);
        sendKeyToElement(sofe.messages,"Hello,I haven't receive my order yet. Can you get me beck as soon as possible? Thanks, John");
        waits(3);
        clickElement(sofe.sendButton);
        String actualText=getTextElement(sofe.verifySuccessfullySubmit);
        String expectedText="Your message has been successfully sent to our team.";
        Assert.assertEquals(actualText,expectedText,"Text did NOT match");
    }

    public void confirmationEmail() {
        clickElement(sofe.enterEmail1);
        sendKeyToElement(sofe.enterEmail1,ConfigReader.getProperty("emailAddress1"));
        clickElement(sofe.clickNext);
        sendKeyToElement(sofe.enterPassword1,ConfigReader.getProperty("password"));
        clickElement(sofe.clickOnNext);
        clickElement(sofe.getFirstEmail);
        String actualText=getTextElement(sofe.verifyEmail);
        String expectedText="Dear Customer,\n" +
                "\n" +
                "Thank you for you email. We have received your submitted form. We will be back to you in 3 business day.\n" +
                "\n" +
                "Regards,\n" +
                "Customer service";
        Assert.assertEquals(actualText,expectedText,"Text DID NOT match");
    }

    public void receiveEmail() {
        clickElement(sofe.enterEmail2);
        sendKeyToElement(sofe.enterEmail2,ConfigReader.getProperty("emailAdmin"));
        clickElement(sofe.enterPassword2);
        sendKeyToElement(sofe.enterPassword2,ConfigReader.getProperty("passwordAdmin"));
        clickElement(sofe.clickLogIn);
        waits(3);
        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle="Dashboard • My Store";
        Assert.assertEquals(actualTitle,expectedTitle,"Titles did not match");
        waits(1);
        clickElement(sofe.clickMessageIcon);
        waits(3);
        clickElement(sofe.showMessage);
        waits(2);
        clickElement(sofe.clickMessage);
        waits(1);
        String actualText=getTextElement(sofe.verifyAdminReceivesMessage);
        String expectedText="Hello,\n" +
                "I haven't receive my order yet. Can you get me beck as soon as possible?\n" +
                "\n" +
                "Thank you\n" +
                "John";
        Assert.assertEquals(actualText,expectedText,"Text Did Not match");





    }

}

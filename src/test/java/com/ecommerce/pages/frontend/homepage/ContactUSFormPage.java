package com.ecommerce.pages.frontend.homepage;

import com.ecommerce.elements.frontend.ContactUSFormElements;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.ecommerce.utility.UploadFile;
import com.ecommerce.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;


public class ContactUSFormPage extends Utility {
/*
1- go to home page   https://ecommerce.yosemiteint.com/prestashop/index.php
2-  click contact us
        * order reference
        * mail address
        * message
        * choose file
        * subject heading
3- choose subject heading
4- put email address "abcd@gmail.com"
5- put order reference
6- put attach file
7- write down message
8- click send button
*/
    public ContactUSFormElements cuf = new ContactUSFormElements();

    public String email = ConfigReader.getProperty("emailAddress1");
    public String name = ConfigReader.getProperty("name");
    public String message = ConfigReader.getProperty("message");

    public void contactUSFormMethod() {
        clickElement(cuf.contactUs);
        scrollToCenter(cuf.subjectHeading);
        selectElementByValue(cuf.subjectHeading, "2");
        sendKeyToElement(cuf.emailAddress,email);
        waits(3);
        sendKeyToElement(cuf.orderReference,name);
       // clickElement(cuf.chooseFile);
      //  waits(5);
      //  sendKeyToElement(cuf.attachFile,name);
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",Driver.getDriver().findElement(By.id("fileUpload")));
        waits(2);
        UploadFile.selectFileToUpload("C:\\Users\\Ayse\\OneDrive\\Desktop\\e-commerce-testing1\\src\\test\\resources\\data\\test.png");
     //   Driver.getDriver().findElement(By.xpath("//input[@type='file']")).click();
        sendKeyToElement(cuf.message,"This is a picture");
        waits(2);

        clickElement(cuf.sendButton);
        String actualText=getTextElement(cuf.verifySuccessfully);
        String expectedText="Your message has been successfully sent to our team.";
        Assert.assertEquals(actualText,expectedText,"Text did NOT match");
    }
}





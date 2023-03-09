package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.Test;

public class SubmissionOfFormTest extends TestBase{
    //Happy Path
    /**1)Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
            *          * Click sign in
     * Fill the requirements field
     *             Enter the email address
     *             Enter the password
     *             Click on signInButton
     *Click contact us
     *Click choose under Subject Heading and click on "Customer Service"
     *Click choose under Order Referance and click on "FKQXWTSFX - 2023-03-04"
     *Click choose under Product and click on"Faded Short Sleeves T-shirt - Size : S, Color : Orange"
     * Click space under "Message" under send key
     *         "Hello,I haven't receive my order yet. Can you get me beck as soon as possible? Thanks, John"
     *Click on "Send"
     *Verify that the user is able to submit the Contact Us form successfully.
     *      "Your message has been successfully sent to our team."

     * 2)Check if user receives a confirmation of email after submitting form
     * Go to url "https://mail.google.com/mail/u/0/#inbox"
     * Click email address and enter email address, click next
     * Enter password, click next
     * Click first email dynamic
     * Verify user receives an email of confirmation for submitted form
     * "Dear Customer,
     Thank you for you email. We have received your submitted form. We will be back to you in 3 business day.
     Regards,
     Customer service"
     *
     *
     *3)Go to Url "https://ecommerce.yosemiteint.com/prestashop/admin123"
     * Fill required fields
     *     click email and enter "admin@ecommerce.yosemiteint.com"
     *     click password and enter admin123
     *     click Log iN
     *Verify that user logged in successfully
     *Click on Message icon
     * click on "Show all messages"
     * click on "johndoe.info67@gmail.com" under customer service
     *Verify that administrator receives the user's message in their email or panel
      Hello,
      I haven't receive my order yet. Can you get me beck as soon as possible?
      Thank you
      John
     */

    public String url = ConfigReader.getProperty("url");
    public String url1 = ConfigReader.getProperty("urlGmail");
    public String url2 = ConfigReader.getProperty("urlAdmin");

    @Test
    public void submitForm(){
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getSofp().submitForm();
    }

    @Test
    public void confirmationEmail(){
        getAppLibrary().getFlowsLibrary().navigateToUrl(url1);
        getAppLibrary().getPage().getSofp().confirmationEmail();
    }

    @Test
    public void receiveEmail(){
        getAppLibrary().getFlowsLibrary().navigateToUrl(url2);
        getAppLibrary().getPage().getSofp().receiveEmail();
    }



}

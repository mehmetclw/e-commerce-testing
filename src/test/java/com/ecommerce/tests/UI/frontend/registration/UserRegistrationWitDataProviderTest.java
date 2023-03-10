package com.ecommerce.tests.UI.frontend.registration;

import com.ecommerce.tests.TestBase.dataprovider.DataProviders;
import com.ecommerce.tests.TestBase.TestBase;
import com.ecommerce.utility.ConfigReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationWitDataProviderTest extends TestBase {
    public String url = ConfigReader.getProperty("url");

    /**
     * Enter valid details and check if the user is able to register successfully.
     * 1- Go to the home page "https://ecommerce.yosemiteint.com/prestashop/index.php"
     * 2- click sign in  //a[@class='login']
     * 3- Enter email  //input[@id='email_create']
     * 4- click create account  //span[text()='Create an account']
     * 6- fill the requirements field
     * Title //input[@id='id_gender2']
     * first name //input[@id='customer_firstname']
     * last name //input[@id='customer_lastname']
     * password //input[@id='passwd']
     * date of birth
     * day   //select[@id='days']//option[@value='12']  /
     * month  //select[@id='months']  /
     * year  //select[@id='years']
     * click register
     */

    @Test(groups = {"smoke", "regression"},dataProvider = "userCredentials")
    public void createNewAccount(String userEmail, String userPassword, String firstName, String lastName) {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getUrp().createNewAccount(userEmail, userPassword, firstName, lastName);
    }

    @DataProvider(name = "userCredentials")
    public Object[][] credentials() {
        return new Object[][]{
                {"aaaaaa@gmail.com", "aa123", "Mike", "Born"},
                {"bbbbbb@gmail.com", "aa1234", "Mary", "Jane"},
                {"cccccc@gmail.com", "aa1235", "John", "Doe"},
                {"dddddd@gmail.com", "aa1236", "Micheal", "Jackson"}
        };
    }

    //when you are calling the dataProvider from different class, we need to use dataProviderClass keyword
    @Test(groups = {"smoke", "regression"},
            dataProvider = "registration", dataProviderClass = DataProviders.class,
            description = "Using couple of parameters")
    public void createNewAccount1(String userEmail, String userPassword, String firstName, String lastName) {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getUrp().createNewAccount(userEmail, userPassword, firstName, lastName);
    }


    @Test(dataProvider = "registration1", dataProviderClass = DataProviders.class,
            description = "If you have too many parameters",
            groups = {"smoke", "regression"})
    public void createNewAccount2(String[] parameter) {
        String userEmail = parameter[0];
        System.out.println("userEmail = " + userEmail);
        String userPassword = parameter[1];
        System.out.println("userPassword = " + userPassword);
        String firstName = parameter[2];
        System.out.println("firstName = " + firstName);
        String lastName = parameter[3];
        System.out.println("lastName = " + lastName);
        String address1 = parameter[4];
        System.out.println("address1 = " + address1);
        String address2 = parameter[5];
        System.out.println("address2 = " + address2);
        String state = parameter[6];
        System.out.println("state = " + state);
        String city = parameter[7];
        System.out.println("city = " + city);
        String zipCode = parameter[8];
        System.out.println("zipCode = " + zipCode);
        System.out.println("===============================\n");

        /*if (driver != null)
            urp.createNewAccount( userEmail,  userPassword, firstName, lastName);
        else System.out.println("Driver is null");*/
    }

    @Test(dataProvider = "registration1", dataProviderClass = DataProviders.class,
            groups = "smoke")
    public void createNewAccount3(String... parameter) {
        String userEmail = parameter[0];
        System.out.println("userEmail = " + userEmail);
        String userPassword = parameter[1];
        System.out.println("userPassword = " + userPassword);
        String firstName = parameter[2];
        System.out.println("firstName = " + firstName);
        String lastName = parameter[3];
        System.out.println("lastName = " + lastName);
        String address1 = parameter[4];
        System.out.println("address1 = " + address1);
        String address2 = parameter[5];
        System.out.println("address2 = " + address2);
        String state = parameter[6];
        System.out.println("state = " + state);
        String city = parameter[7];
        System.out.println("city = " + city);
        String zipCode = parameter[8];
        System.out.println("zipCode = " + zipCode);
        System.out.println("===============================\n");

        /*if (driver != null)
            urp.createNewAccount( userEmail,  userPassword, firstName, lastName);
        else System.out.println("Driver is null");*/
    }

}

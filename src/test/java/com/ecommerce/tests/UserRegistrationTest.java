package com.ecommerce.tests;

import com.ecommerce.dataprovider.DataProviders;
import com.ecommerce.utility.ConfigReader;
import com.ecommerce.utility.Driver;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Date;

public class UserRegistrationTest extends TestBase {
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

    @Test(groups = "smoke", description = "Create new Account using different credentials")
    public void createNewAccount() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
            getAppLibrary().getPage().getUrp().createNewAccount();
    }

    @Test
    public void fakerTest() {
        Faker fake = new Faker();
        String name = fake.name().fullName();
        String email = fake.internet().emailAddress();
        System.out.println("fake.name().firstName() = " + fake.name().firstName());
        System.out.println("fake.name().lastName() = " + fake.name().lastName());
        System.out.println("fake.name().name() = " + fake.name().name());
        System.out.println("email = " + email);
        System.out.println("name = " + name);
    }

    static { //To initialize the Sheet name from Test class instead of hard coding in DataProvider.
        //  System.setProperty("excelSheet", ConfigReader.getProperty("excelSheet"));
        System.setProperty("excelSheet", "Sheet1");
        System.setProperty("FoodSales", "FoodSales");
    }

    @Test(dataProvider = "readDataFromExcel", dataProviderClass = DataProviders.class)
    public void test5(Object name, Object email, Object password) {
        System.out.println(name + " " + email + " " + password);
        System.out.println("===========");

    }

    @Test(dataProvider = "readDataFromExcelFiles", dataProviderClass = DataProviders.class)
    public void test6(Object... values) {
       /* String date = (String) values[0];
        String region= (String) values[1];
        String city=(String) values[2];
        String category= (String) values[3];
        String product= (String) values[4];
        Double quantity= (Double) values[5];*/
        System.out.println(values[0] + " " + values[1] + " " + values[2] + " " +
                values[3] + " " + values[4] + " " + values[5] + " " +
                values[6] + " " + values[7]);
        System.out.println("===========");

    }
}
//OrderDate	Region	City	Category	Product	Quantity	UnitPrice	TotalPrice
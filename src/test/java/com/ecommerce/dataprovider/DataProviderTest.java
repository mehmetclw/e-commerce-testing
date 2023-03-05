package com.ecommerce.dataprovider;

import com.ecommerce.utility.library.ReadExcelLib;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @DataProvider
    public Object[][] dataProvider() {

        ReadExcelLib excel = new ReadExcelLib();
        String file = System.getProperty("user.dir") + "src/test/resources/data/TestData.xlsx";
        return excel.Get_Excel_Data(file, "Sheet1", 3);
    }

    @Test(dataProvider = "dataProvider1", dataProviderClass = DataProviderTest.class)
    public void test5(String name, String email, String password) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(password);
        System.out.println("===========");

    }

}

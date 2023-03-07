package com.ecommerce.dataprovider;

import com.ecommerce.utility.ReadExcelLib;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
    @DataProvider(name = "dataProvider1")
    public Object[][] dataProvider() {

        ReadExcelLib excel = new ReadExcelLib();
        String file = System.getProperty("user.dir") + "/src/test/resources/data/TestData.xlsx";
        return excel.Get_Excel_Data(file, "Sheet1", 3);
    }

}

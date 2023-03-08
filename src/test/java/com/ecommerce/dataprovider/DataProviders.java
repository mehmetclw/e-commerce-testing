package com.ecommerce.dataprovider;

import com.ecommerce.utility.ReadExcelLib;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class DataProviders {
    ReadExcelLib excel = new ReadExcelLib();

    @DataProvider(name = "readDataFromExcel")
    public Object[][] dataProviderExcelReading() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/data/TestData.xlsx";
        return excel.get_Excel_Data(filePath, System.getProperty("excelSheet"), 3);
    }
    @DataProvider(name = "readDataFromExcelFiles")
    public Object[][] dataProviderExcelReadingFoodSales() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/data/sampledatafoodsales.xlsx";
        return excel.get_Excel_Data(filePath, System.getProperty("FoodSales"), 8);
    }

    @DataProvider(name = "userCredentials")
    public Object[][] credentials() {
        return new Object[][]{
                {"aaaaaa1@gmail.com", "aa123", "Mike", "Born"},
                {"bbbbbb2@gmail.com", "aa1234", "Mary", "Jane"},
                {"cccccc3@gmail.com", "aa1235", "John", "Doe"},
                {"dddddd4@gmail.com", "aa1236", "Micheal", "Jackson"}
        };
    }

    @DataProvider(name = "registration")
    public Object[][] userRegistration() {
        return new Object[][]{
                {"aaaaaa11@gmail.com", "aa123", "Mike", "Born"},
                {"bbbbbb22@gmail.com", "aa1234", "Mary", "Jane"},
                {"cccccc33@gmail.com", "aa1235", "John", "Doe"},
                {"dddddd44@gmail.com", "aa1236", "Micheal", "Jackson"}
        };
    }

    @DataProvider(name = "registration1")
    public Object[][] userRegistrations() {
        return new Object[][]{
                {"aaaaaa11@gmail.com", "aa123", "Mike", "Born","591 main st","suite 51","GA","Atlanta","34443"},
                {"bbbbbb22@gmail.com", "aa1234", "Mary", "Jane","591 main st","suite 51","GA","Atlanta","34443"},
                {"cccccc33@gmail.com", "aa1235", "John", "Doe","591 main st","suite 51","GA","Atlanta","34443"},
                {"dddddd44@gmail.com", "aa1236", "Micheal", "Jackson","591 main st","suite 51","GA","Atlanta","34443"}
        };
    }
}

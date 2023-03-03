package com.ecommerce.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {

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

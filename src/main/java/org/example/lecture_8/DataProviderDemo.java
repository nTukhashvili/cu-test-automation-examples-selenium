package org.example.lecture_8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    @DataProvider(name = "testData")
    public Object[][] createData() {
        return new Object[][] {
                { "Data 1" },
                { "Data 2" },
                { "Data 3" }
        };
    }

    @Test(dataProvider = "testData")
    public void testMethod(String data) {
        System.out.println("Received data: " + data);
    }
}

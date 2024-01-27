package com.API.setup;

import org.example.Utils.Config.data.ExcelUtils;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {


    @DataProvider(name = "entries_test_data")
    public Object[][] getEntriesTestData() {
        return testData("resources/test_data/test_data.xlsx"
                , "Sheet1");
    }
    @DataProvider(name = "random_test_data")
    public Object[][] getRandomTestData() {
        return testData("resources/test_data/test_data.xlsx"
                , "Sheet2");
    }

    public Object[][] testData(String excelPath, String sheetName) {
        ExcelUtils excel;
        excel = new ExcelUtils(excelPath, sheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = excel.getCellDataString(i, j);
                System.out.print(cellData + " | ");
                data[i - 1][j] = cellData;
            }
        }
        return data;
    }

}
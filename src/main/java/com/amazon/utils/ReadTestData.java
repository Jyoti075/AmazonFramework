package com.amazon.utils;

import com.amazon.base.BaseClass;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadTestData extends BaseClass {

    public static Object[][] readTestData(String sheetName) throws IOException {
        FileInputStream excel_file = new FileInputStream("/Users/jyoti/IdeaProjects/Amazon_Framework/src/main/java/com/amazon/testdata/testdata_1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(excel_file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
            }
        }
        return data;
    }
}


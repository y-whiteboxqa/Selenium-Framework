package com.ebank.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ebank.base.TestBase;

public class TestUtil extends TestBase{

    // can change timeouts if required
    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 20;

    
    // reading data from excel file
    public static String TESTDATA_SHEET_PATH = "/Users/yamuna/eclipse-workspace/EbankFramework/src/main/java/com/ebank/testData/CustomerDetails.xlsx";

    public static Workbook book;
    public static Sheet sheet;
    

    public static Object[][] getTestData(String sheetName) {

        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                // System.out.println(data[i][j]);
                
            }
        }
        return data;
    }
    
    
    // method to take screen shot when exceptions occurs (using File handler class)
    // and call this method from WebEventListener class 
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

}

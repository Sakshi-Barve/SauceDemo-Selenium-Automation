package testPackage;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.Flib;
import pagePackage.HomePage;
import pagePackage.LoginPage;

public class FilterTest extends BaseTest{

    LoginPage login;
    HomePage home;
    Flib flib = new Flib();
    @BeforeTest
    public void loginApp() throws InterruptedException {
        login = new LoginPage(driver);
        login.validLoginMethod("standard_user", "secret_sauce");
        home = new HomePage(driver);
    }

    //option 1
    @Test
    public void testAllFiltersFromExcel() throws EncryptedDocumentException, IOException, InterruptedException {
        String sheetName = "FilterOps";
        int rowCount = flib.getRowCount(FilterEXCEL_PATH, sheetName);

        for (int i = 1; i < rowCount; i++) { // corrected loop
            String filterName = flib.readExcelData(FilterEXCEL_PATH, sheetName, i, 0);
            System.out.println("Applying filter from Excel: '" + filterName + "'");

            home.selectFilter(filterName);
            Thread.sleep(1000);

            String selected = home.getSelectedFilterOption();
            System.out.println("✅ Applied filter: " + selected);
            Assert.assertEquals(selected, filterName, "❌ Filter mismatch at row " + i);
        }
    }

    
    //option 2
//    @Test
//    public void testAllFilters() throws InterruptedException {
//        // Array of all filter options
//        String[] filters = {"Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)"};
//
//        for (String filter : filters) {
//            // Select filter
//            home.selectFilter(filter);
//            Thread.sleep(1000); // Wait for UI to update
//
//            // Verify the selected filter
//            String selected = home.getSelectedFilterOption();
//            System.out.println("🔽 Applied filter: " + selected);
//
//            // Optional assertion
//            Assert.assertEquals(selected, filter, "❌ Filter mismatch!");
//        }
//    }
    

    
}
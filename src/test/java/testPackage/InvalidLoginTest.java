package testPackage;


import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.Flib;
import pagePackage.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTC() throws IOException, EncryptedDocumentException, InterruptedException {

        Flib flib = new Flib();
        LoginPage lp = new LoginPage(driver);

        int rc = flib.getRowCount(EXCEL_PATH, "InValidTestData");

        for(int i = 1; i <= rc; i++) {
            String usernameData = flib.readExcelData(EXCEL_PATH, "InValidTestData", i, 0);
            String passwordData = flib.readExcelData(EXCEL_PATH, "InValidTestData", i, 1);

            lp.invalidLoginMethod(usernameData, passwordData);
         // ✅ Add assertion here 
            String actualError = lp.getErrorMessage().getText(); 
            String expectedError = "Epic sadface: Username and password do not match any user in this service"; 
            Assert.assertEquals(actualError, expectedError, "❌ Error message mismatch for data: " + usernameData + " / " + passwordData);
            
         
        
        }
    }
}


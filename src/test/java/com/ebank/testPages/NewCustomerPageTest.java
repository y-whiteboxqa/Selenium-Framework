package com.ebank.testPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.ebank.base.TestBase;
import com.ebank.pages.HomePage;
import com.ebank.pages.LoginPage;
import com.ebank.pages.NewCustomerPage;
import com.ebank.util.TestUtil;

public class NewCustomerPageTest extends TestBase{

    NewCustomerPage newCustomerPage;
    LoginPage loginPage;
    HomePage homePage;

    String sheetName = "Sheet 1";

    public NewCustomerPageTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        initialization(browser);
        newCustomerPage = new NewCustomerPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        newCustomerPage = homePage.clickNewCustomerLink();

    }

    @Test(priority = 1)
    public void verifyPageLabel() {
        Assert.assertTrue(newCustomerPage.verifyPageLabel(), "Page label is missing");
    }

    @DataProvider
    public Object[][] getCustomerDetails() {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 2, dataProvider = "getCustomerDetails")
    public void validateCreateNewcustomer(String name, String address, String city, String state, String pin,
            String cellNo, String email) {

        newCustomerPage.createNewCustomer(name, address, city, state, pin, cellNo, email);

    }

    
 
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

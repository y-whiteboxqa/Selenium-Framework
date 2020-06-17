package com.ebank.testPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;

import com.ebank.base.TestBase;
import com.ebank.pages.HomePage;
import com.ebank.pages.LoginPage;

public class LoginPageTest extends TestBase{

 // create a constructor of login page
    LoginPage loginPage;

    // create HomePage reference variable
    HomePage homePage;

    public LoginPageTest() {
        super();
    }
   
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {

        // calling initialization method from TestBase class
        initialization(browser);
        loginPage = new LoginPage();

    }

    @Test(priority = 1)
    public void loginPageTitle() {

        // call method from LoginPage class
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "GTPL Bank Home Page");

    }

    @Test(priority = 2)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

   
   
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

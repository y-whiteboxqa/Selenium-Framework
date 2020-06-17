package com.ebank.testPages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import com.ebank.base.TestBase;
import com.ebank.pages.HomePage;
import com.ebank.pages.LoginPage;
import com.ebank.pages.NewAccountPage;
import com.ebank.pages.NewCustomerPage;

public class HomePageTest extends TestBase{

    LoginPage loginPage;
    HomePage homePage;
    NewCustomerPage newCustomerPage;
    NewAccountPage newAccountPage;

    public HomePageTest() {
        super();
    }

  
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        initialization(browser);
        loginPage = new LoginPage();
        newCustomerPage = new NewCustomerPage();
        newAccountPage = new NewAccountPage();
        homePage = new HomePage();

        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "GTPL Bank Manager HomePage", "HomePage title not matched");
        // the above message will print if the test case get failed
    }

    @Test(priority = 2)
    public void verifyWelcomeLabelTest() {
        Assert.assertTrue(homePage.verifyWelcomeLabel());
    }

    @Test(priority = 3)
    public void verifyNewCustomerLink() {
        newCustomerPage = homePage.clickNewCustomerLink();
    }

    @Test(priority = 4)
    public void verifyNewAccountLink() {
        newAccountPage = homePage.clickNewAccountLink();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}

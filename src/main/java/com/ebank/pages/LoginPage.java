package com.ebank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebank.base.TestBase;

public class LoginPage extends TestBase{

    // page factory - Object repository

    @FindBy(name = "uid")
   // @CacheLookup
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement loginButton;

    // initializing page objects
    // login page constructor
    public LoginPage() {
        PageFactory.initElements(driver, this); // using this method we initialize page factory
    }

    // actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public HomePage login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();

        // after clicking login it will take you to home page.so this method returns
        // HomePage
        return new HomePage();
    }
 
}

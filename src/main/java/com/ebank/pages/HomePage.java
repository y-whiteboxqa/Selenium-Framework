package com.ebank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebank.base.TestBase;


public class HomePage extends TestBase{

    @FindBy(className = "heading3")
    WebElement welcomeLabel;

    @FindBy(linkText = "New Customer")
    WebElement newCustomerLink;

    @FindBy(linkText = "New Account")
    WebElement newAccountLink;

    // Initializing page objects
    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {

        return driver.getTitle();
    }

    public boolean verifyWelcomeLabel() {

        return welcomeLabel.isDisplayed();
    }

    // this method returns next lending page object (page chaining model)
    public NewCustomerPage clickNewCustomerLink() {
        newCustomerLink.click();
        return new NewCustomerPage();

    }

    public NewAccountPage clickNewAccountLink() {
        newAccountLink.click();
        return new NewAccountPage();
    }

}

package com.ebank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ebank.base.TestBase;

public class NewCustomerPage extends TestBase{

    
    @FindBy(xpath = "//p[@class='heading3']")
    WebElement pageLabel;

    @FindBy(name = "name")
    WebElement customerName;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
    WebElement maleBtn;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
    WebElement femaleBtn;

    @FindBy(id = "dob")
    WebElement dateOfBirth;

    @FindBy(name = "addr")
    WebElement customerAddress;

    @FindBy(name = "city")
    WebElement customerCity;

    @FindBy(name = "state")
    WebElement customerState;

    @FindBy(name = "pinno")
    WebElement customerPin;

    @FindBy(name = "telephoneno")
    WebElement telephoneNumber;

    @FindBy(name = "emailid")
    WebElement customerEmail;

    @FindBy(name = "sub")
    WebElement submitBtn;

    @FindBy(name = "res")
    WebElement resetBtn;

    // initializing page objects
    public NewCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyPageLabel() {
        return pageLabel.isDisplayed();
    }

    public void createNewCustomer(String name, String address, String city, String state, String pin, String cellNo, String email) {

        customerName.sendKeys(name);
        maleBtn.click();

        /*  String date
         * Select select = new Select(dateOfBirth); 
         * select.selectByVisibleText(date);
         */

        customerAddress.sendKeys(address);
        customerCity.sendKeys(city);
        customerState.sendKeys(state);
        customerPin.sendKeys(pin);
        telephoneNumber.sendKeys(cellNo);
        customerEmail.sendKeys(email);
        submitBtn.click();

        
    }

}

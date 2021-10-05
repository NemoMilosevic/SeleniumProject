package com.cybertek.pages;

import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W_LoginPage {

    // instructing selenium to find username element by using id
    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameField;

    // instructing selenium to find password element by using name
    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordField;

    // instructing selenium to find login button element by using css
    @FindBy(css = "#ctl00_MainContent_login_button")
    public WebElement loginButton;

    // instructing selenium to find error message element by using xpath
    @FindBy(xpath = "//*[@id='ctl00_MainContent_status']")
    public WebElement errorMessage;

    // instructing selenium to find elements when CONSTRUCTOR BELOW is called (using this keyword)
    // PageFactory is selenium class that supports Page Object Model
    public W_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("webOrder_url"));
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username); // we can use -> this.usernameField.sendKeys(username)
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean loginErrorMsgPresent(){
        return errorMessage.isDisplayed();
    }

}

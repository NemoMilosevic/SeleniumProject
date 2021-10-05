package com.cybertek.pages;

import com.cybertek.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W_CommonArea {

    @FindBy(id = "ctl00_logout")
    public WebElement logoutButton;

    @FindBy(linkText = "View all orders")
    public WebElement viewAllOrdersTab;

    @FindBy(linkText = "View all products")
    public WebElement viewAllProductsTab;

    @FindBy(linkText = "Order")
    public WebElement orderTab;

    public W_CommonArea(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}

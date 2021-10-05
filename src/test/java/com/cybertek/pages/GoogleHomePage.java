package com.cybertek.pages;

import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public GoogleHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void goTo(){
        Driver.getDriver().get(ConfigReader.read("google.url"));
    }

    public void searchKeyword(String keyword){
        searchBox.sendKeys(keyword);
        searchButton.click();
    }

    public boolean isAt(){
        return Driver.getDriver().getTitle().equals("Google");
    }


}
/*
- Google homepage
 Fields :
 - searchBox element
 - search button
 Methods
  - searchKeyWord
    - accept 1 string param as keyword
    - return nothing
    - should enter keyword and click search button
  - isAt
    - accept no param
    - return true if title match , false if not
  - goTo
     - void method with no param and navigate to google (use config reader for url)
 */
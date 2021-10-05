package com.cybertek.pages;

import com.cybertek.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultPage {

    @FindBy(id = "result-stats")
    public WebElement searchResultCount;

    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
    public List<WebElement> resultLinks;

    public GoogleResultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getResultCountText(){
        return searchResultCount.getText();
    }

    public void printAllSearchResultLinks(){
        System.out.println("Result Links Size = " + resultLinks.size());
        for (WebElement each : resultLinks) {
            System.out.println("Result Link = " + each.getText());
        }
    }


}
/*
- Google SearchResultPage
  - Fields
     searchResultCount
     resultLinks (list of WebElement )
  - Methods
     getResultCountText
     getAllResultLinkText

     * Print out the text of all resulting links
 */
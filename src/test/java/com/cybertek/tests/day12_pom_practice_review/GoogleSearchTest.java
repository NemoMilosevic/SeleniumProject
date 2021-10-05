package com.cybertek.tests.day12_pom_practice_review;

import com.cybertek.pages.GoogleHomePage;
import com.cybertek.pages.GoogleResultPage;
import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchTest extends TestBase {

    @Test
    public void testGoogleSearch(){

        GoogleHomePage homePage = new GoogleHomePage();
        homePage.goTo();
        assertTrue(homePage.isAt());
        homePage.searchKeyword("SDET job");
        assertTrue(driver.getTitle().startsWith("SDET job"));

        GoogleResultPage resultPage = new GoogleResultPage();
        String resultText = resultPage.getResultCountText();
        System.out.println("resultText = " + resultText);

        resultPage.printAllSearchResultLinks();

        BrowserUtility.waitFor(3);

    }



}
package com.cybertek.tests.day05_css_xpath_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*; // Import Assertions class

public class YahooSearchPageTest {

    WebDriver driver;

    @BeforeAll
    public static void setUpChromeDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupWebDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quitBrowser(){
        driver.quit();
    }

    @AfterAll
    public static void teardown(){
        System.out.println("@AfterAll - nothing to do here");
    }

    // 1. navigate to https://www.search.yahoo.com and verify the title is "Yahoo Search - Web Search"

    @Test
    public void testYahooSearchHomePageTitle(){

        driver.get("https://www.search.yahoo.com");
        String expectedTitle = "Yahoo Search - Web Search";
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle,actualTitle);

    }

    // 2. test method name : testYahooSearchResultPageTitle
    //    test navigate to yahoo page and search for Selenium (page title should start with selenium)

    @Test
    public void testYahooSearchResultPageTitle(){

        driver.get("https://www.search.yahoo.com");

        // identify searchBar and enter Selenium and hit Enter key on keyboard
        WebElement searchBar = driver.findElement(By.xpath("//input[@type='text']"));
        // we can simulate a keystroke by using command Keys.ENTER
        searchBar.sendKeys("Selenium"+ Keys.ENTER);

        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.startsWith("Selenium"));

    }

}

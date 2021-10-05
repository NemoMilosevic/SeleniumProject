package com.cybertek.tests.day06_junit_practice_utility_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class IsDisplayedPracticeTest {

    WebDriver driver;

    @BeforeEach
    public void setupWebDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    // navigate to the form page
    // identify error msg exist but not displayed
    // enter text "a" and check the error msg is displayed
    /**
     * small[data-bv-for='firstname'][data-bv-validator='stringLength]
     * //small[.='first name must be more than 2 and less than 64 characters long']
     */

    @Test
    public void testErrorMsg() {
        driver.get("http://practice.cybertekschool.com/registration_form");
        String xpathForErrorMsg = "//small[.='first name must be more than 2 and less than 64 characters long']";
        WebElement strLengthErrorElement = driver.findElement(By.xpath(xpathForErrorMsg));
        System.out.println("strLengthErrorElement.isDisplayed() = " + strLengthErrorElement.isDisplayed());

        WebElement firstNameBar = driver.findElement(By.name("firstname"));
        firstNameBar.sendKeys("a");

        System.out.println("strLengthErrorElement.isDisplayed() = " + strLengthErrorElement.isDisplayed());

        assertTrue(strLengthErrorElement.isDisplayed());


    }
}

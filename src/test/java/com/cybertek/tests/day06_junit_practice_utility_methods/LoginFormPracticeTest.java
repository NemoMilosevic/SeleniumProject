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

public class LoginFormPracticeTest {

    // http://practice.cybertekschool.com/login

    // verify header is "Login Page" by xpath: //*[@id="content"]/div/h2

    // user name bar by xpath: //*[@id="login"]/div[1]/div/input  ->  tomsmith

    // password bar by xpath: //*[@id="login"]/div[2]/div/input  ->   SuperSecretPassword

    // login button by xpath: //*[@id="wooden_spoon"]

    // verify message on top by xpath and print it out:  //*[@id="flash"]

    WebDriver driver;

    @BeforeEach
    public void setupWebDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testLogin(){
        driver.get("http://practice.cybertekschool.com/login");
        WebElement header = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
        System.out.println("header.getText() = " + header.getText());

        WebElement usernameBar = driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input"));
        usernameBar.sendKeys("tomsmith");
        WebElement passBar = driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/input"));
        passBar.sendKeys("SuperSecretPassword");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]"));
        loginButton.submit();

        WebElement secureAreaMsg = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String expectedResult = "You logged into a secure area!"+"\n"+"×";
        assertEquals(expectedResult, secureAreaMsg.getText());



    }


}

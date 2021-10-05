package com.cybertek.day05_css_xpath_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPractice1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // // * [ @id = 'content']/div/h2 or //h2[ text() = 'Forgot Password']
        //          copied from xpath                 found manually
        WebElement forgotPassHeader = driver.findElement(By.xpath("//h2[ text() = 'Forgot Password']"));
        System.out.println("forgotPassHeader.getText() = " + forgotPassHeader.getText());

        WebElement emailBox = driver.findElement(By.xpath("//*[@id=\"forgot_password\"]/div/div/input"));
        emailBox.sendKeys("someone@somewhere.com");

        WebElement retrieveButton = driver.findElement(By.xpath("//*[@id=\"form_submit\"]/i"));
        retrieveButton.submit();

        WebElement confirmationMsg = driver.findElement(By.xpath("//*[@id=\"content\"]/h4"));
        System.out.println("confirmationMsg.getText() = " + confirmationMsg.getText());

        String confirmationMsgStr = "//h4[text()=\"Your e-mail's been sent!\"]";
        System.out.println("confirmationMsgStr = " + confirmationMsgStr);


        driver.quit();


    }
}

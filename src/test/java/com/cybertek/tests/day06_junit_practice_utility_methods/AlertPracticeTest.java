package com.cybertek.tests.day06_junit_practice_utility_methods;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class AlertPracticeTest extends TestBase {

    @Test
    public void testJavaScriptAlert() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[1]")).click();
        Thread.sleep(3000);

        System.out.println("Getting text from alert 1 = " + driver.switchTo().alert().getText());

        driver.switchTo().alert().accept(); // switchTo() method is followed by alert()
                                            // in order to switch from html to JavaScript
                                            // there are 4 methods:
                                                // accept() -> clicks the ok button
                                                // dismiss() -> clicks the cancel button
                                                // sendKeys() -> inputs a text (String)
                                                // getText() -> get text of alert box

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[2]")).click();
        Thread.sleep(3000);
        System.out.println("Getting text from alert 2 = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[3]")).click();
        Thread.sleep(3000);
        System.out.println("Getting text from alert 3 = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);


    }
}

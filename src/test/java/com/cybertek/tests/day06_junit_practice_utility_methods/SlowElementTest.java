package com.cybertek.tests.day06_junit_practice_utility_methods;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SlowElementTest extends TestBase {

    @Test
    public void testWait() {

        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        //Thread.sleep(5000); --> use implicitWait command below (instead of Thread.sleep)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement itsGoneElement = driver.findElement(By.id("message"));
        System.out.println("itsGoneElement.getText() = " + itsGoneElement.getText());

    }

}

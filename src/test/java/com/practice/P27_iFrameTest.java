package com.practice;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P27_iFrameTest extends TestBase {

    @Test
    public void test_iFrame() {

        driver.get("http://practice.cybertekschool.com/iframe");

        // switch to the iframe by using index
        //driver.switchTo().frame(0);

        // switch to the iframe by using id or name
        //driver.switchTo().frame("mce_0_ifr");

        // switch to the iframe by WebElement
        WebElement iFrameElm = driver.findElement(By.cssSelector("iframe[title^='Rich Text Area']"));
        driver.switchTo().frame(iFrameElm);

        // identify p element inside the frame
        WebElement pTagElementInsideFrame = driver.findElement(By.tagName("p"));
        System.out.println("pTagElementInsideFrame.getText() = " + pTagElementInsideFrame.getText());

        // switch out of the frame
        driver.switchTo().defaultContent(); // switch to top level html
        driver.switchTo().parentFrame(); // switch to one level up inside nested html document

        // click on home button to get back to main practice page
        driver.findElement(By.linkText("Home")).click();

    }

    @Test
    public void test_Nested_iFrame() {

        driver.get("http://practice.cybertekschool.com/nested_frames");

        //main content --> top, bottom frame
        // top --> left, middle, right frame

        // get text out of bottom frame
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrameBodyElm = driver.findElement(By.tagName("body"));
        System.out.println("bottomFrameBodyElm.getText() = " + bottomFrameBodyElm.getText());

        // switch out to parent frame (2 ways below)
        // driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        // switch to middle frame and get text -> go to top frame and then to middle frame
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middleFrameBodyElm = driver.findElement(By.id("content"));
        System.out.println("middleFrameDiv.getText() = " + middleFrameBodyElm.getText());

        // navigate to right frame and get text
        driver.switchTo().parentFrame(); // we are on top frame now
        driver.switchTo().frame("frame-right");
        WebElement rightFrameBodyElm = driver.findElement(By.tagName("body"));
        System.out.println("rightFrameBodyElm.getText() = " + rightFrameBodyElm.getText());

    }
}
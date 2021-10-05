package com.cybertek.tests.day07_iFrame;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFrameTest extends TestBase {

    @Test
    public void testSimpleIFrame(){

        driver.get("http://practice.cybertekschool.com/iframe");

        // 1. switch to the iframe by using index number
        //driver.switchTo().frame(0);

        // 2. switch to the iframe by using id (or name)
        //driver.switchTo().frame("mce_0_ifr");

        // 3. switch to the iframe by using WebElement
        WebElement iFrameElm = driver.findElement(By.cssSelector("iframe[title^='Rich Text Area']"));
        driver.switchTo().frame(iFrameElm);

        // locate p element inside the iframe
        WebElement pTagInsideFrame = driver.findElement(By.tagName("p"));
        System.out.println("pTagElementInsideFrame.getText() = " + pTagInsideFrame.getText());

        // 2 ways to get out of the frame
        // jump one level out of the frame:
        // driver.switchTo().parentFrame(); --> First Way
        // jump all the way to the main content (this will get you out of any level inside the frame)
        driver.switchTo().defaultContent(); // --> Second Way
        // click on the Home link on top left corner
        driver.findElement(By.linkText("Home")).click();

        System.out.println("THE END");


    }


}

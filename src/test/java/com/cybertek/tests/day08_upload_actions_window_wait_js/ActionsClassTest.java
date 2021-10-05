package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.*;


public class ActionsClassTest extends TestBase {

    @Test
    public void testHoverAction() {

        driver.get("http://practice.cybertekschool.com/hovers");

        // locate first image, hover over and verify User profile 1 is displayed
        WebElement firstImgElm = driver.findElement(By.xpath("(//div[@class='figure']/img)[1]"));

        // create instance (object) of Actions class by passing driver object
        Actions actions = new Actions(driver);
        actions.moveToElement(firstImgElm).perform();

        BrowserUtility.waitFor(3);

        // verify User profile 1 is displayed with text "name: user1"
        WebElement firstImgText = driver.findElement(By.xpath("//h5[.='name: user1']"));
        assertTrue(firstImgText.isDisplayed());
        System.out.println("firstProfileElm.getText() = " + firstImgText.getText());

        // locate second image, hover over and verify User profile 2 is displayed
        WebElement secondImgElm = driver.findElement(By.xpath("(//div[@class='figure']/img)[2]"));
        actions.moveToElement(secondImgElm).perform();

        BrowserUtility.waitFor(3);

        // verify User profile 2 is displayed with text "name: user2"
        WebElement secondImgText = driver.findElement(By.xpath("//h5[.='name: user2']"));
        assertTrue(secondImgText.isDisplayed());
        System.out.println("secondProfileElm.getText() = " + secondImgText.getText());

        // locate third image, hover over and verify User profile 3 is displayed
        WebElement thirdImgElm = driver.findElement(By.xpath("(//div[@class='figure']/img)[3]"));
        actions.moveToElement(thirdImgElm).perform();

        BrowserUtility.waitFor(3);

        // verify User profile 3 is displayed with text "name: user3"
        WebElement thirdImgText = driver.findElement(By.xpath("//h5[.='name: user3']"));
        assertTrue(thirdImgText.isDisplayed());
        System.out.println("thirdProfileElm.getText() = " + thirdImgText.getText());

        // perform these actions below:
        // hover over to 1st image, pause for 2 seconds, then second image, then pause for 2 seconds
        // then hover over to 1st image again, then pause 2 seconds, then second image, pause 2 second
        // PERFORM THE ACTION!!!
        actions.moveToElement(firstImgElm).pause(2000)
                .moveToElement(secondImgElm).pause(2000)
                .moveToElement(firstImgElm).pause(2000)
                .moveToElement(secondImgElm).pause(2000)
                .perform();
    }

    @Test
    public void testDragAndDrop() {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtility.waitFor(2);

        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement biggerCircle = driver.findElement(By.id("droptarget"));

        // dragAndDrop method of Actions class, accept 2 elements and drop first into second
        Actions actions = new Actions(driver);
        actions.dragAndDrop(smallCircle,biggerCircle).perform();

        BrowserUtility.waitFor(3);

        // verify the bigger circle text has changed into "You did great!"
        assertEquals("You did great!",biggerCircle.getText());

    }

    @Test
    public void testKeyboardAction(){

        driver.get("https://www.google.com/");

        // locate searchBox using name value "q"
        // create Actions class interface
        // hold down Shift button, enter text "I love Selenium", release Shift and re-enter same text
        // select entire text (command+A), release command key and hit backspace to delete
        WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        // keyDown method -> for holding certain modifier keys, like Control, SHIFT, etc.
        // keyUp method -> for releasing what you were holding to
        // sendKeys method (of Actions class) -> is for pressing the key
        // pause method (of Actions class) -> for pausing between actions for amount of milliseconds
        actions.keyDown(Keys.SHIFT).sendKeys("i love selenium");
//                    .pause(2000).keyUp(Keys.SHIFT)
//                    .sendKeys("i love selenium").pause(2000)
//                    .keyDown(Keys.COMMAND).sendKeys("A")
//                    .perform();

        actions.keyDown(Keys.SHIFT).sendKeys("i love selenium")
                .pause(2000).keyUp(Keys.SHIFT)
                .sendKeys("i love selenium").pause(2000)
                .keyDown(Keys.COMMAND).sendKeys("A")
                .keyUp(Keys.COMMAND).pause(2000)
                .sendKeys(Keys.BACK_SPACE)
                .perform();

    }

    @Test
    public void testDoubleClick(){

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");

        // double-click on "paragraph", then assert the new paragraph displayed "Hello World"
        // both elements are under iframe with id = iframeResult
        driver.switchTo().frame("iframeResult");
        WebElement pElm1 = driver.findElement(By.xpath("//p[.='Double-click this paragraph to trigger a function.']"));
        // in order to double-click, we use Actions class, and perform() command at the end
        Actions actions = new Actions(driver);
        actions.doubleClick(pElm1).perform();

        BrowserUtility.waitFor(3);

        WebElement text = driver.findElement(By.id("demo"));
        System.out.println("text.getText() = " + text.getText());

        Assertions.assertEquals("Hello World",text.getText());

    }

    @Test
    public void testRightClick(){

        // RIGHT CLICK = CONTEXT CLICK

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_oncontextmenu");

        // locate the yellow area, right-click on that area using Actions class and close the alert
        driver.switchTo().frame("iframeResult");
        WebElement yellowArea = driver.findElement(By.cssSelector("div[contextmenu='mymenu']"));
        Actions actions = new Actions(driver);
        actions.contextClick(yellowArea).perform();

        BrowserUtility.waitFor(2);



    }

}
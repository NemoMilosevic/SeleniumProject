package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class WindowTest extends TestBase {

    @Test
    public void testWindowOrTab(){

        // selenium does not differentiate between window and tab, and sees everything as new window
        driver.get("http://practice.cybertekschool.com/windows");

        // get windowHandle and save it into the currentHandle variable
        String currentHandle = driver.getWindowHandle();
        System.out.println("currentHandle = " + currentHandle);

        // get allHandles and print it out
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("allHandles = " + allHandles);

        // click on the link to generate a new window
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click(); // this will open a new tab, and you'll have 2 tabs total

        // now print out current window handle and all window handles
        System.out.println("After clicking driver.getWindowHandle() = " + driver.getWindowHandle());
        System.out.println("After clicking driver.getWindowHandles() = " + driver.getWindowHandles());

        // iterate each item and every handle, use switchTo method to switch, and print title
        allHandles = driver.getWindowHandles(); // this will give us latest all handles
        for (String eachHandle : allHandles) {
            System.out.println("eachHandle = " + eachHandle);
            driver.switchTo().window(eachHandle);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        System.out.println("Switching back to Original Tab...");

        driver.switchTo().window(currentHandle);
        System.out.println("current tab title = " + driver.getTitle());
        assertEquals("Practice",driver.getTitle());


    }


}

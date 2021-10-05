package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class FileUploadTest extends TestBase {

    @Test
    public void testUpload() {

        driver.get("http://practice.cybertekschool.com/upload");

        // locate the input field
        WebElement fileInputField = driver.findElement(By.id("file-upload"));

        // find full path of your file (.jpg) and send keys into input field (hold option/alt and copy)
        String filePath = "/Users/nemo/Pictures/barCode.jpg";
        fileInputField.sendKeys(filePath);

        BrowserUtility.waitFor(2); // method we created in order to wait for 2 seconds

        // locate Upload button and click (submit)
        driver.findElement(By.id("file-submit")).submit();

        BrowserUtility.waitFor(2); // method we created in order to wait for 2 seconds

        // Assert "File Uploaded!" success message showed --> By.xpath: //h3[.='File Uploaded!']
        WebElement successMsg = driver.findElement(By.xpath("//h3[.='File Uploaded!']"));
        assertTrue(successMsg.isDisplayed());

        // Thread.sleep(2000); is needed sometimes, but we are forced to deal with checked exception
        // objective --> have a human-readable utility method, so we can call like this:
        // BrowserUtil.waitFor(2); === >> no exception handling just wait for 2 seconds
        // Create a class called BrowserUtil under utility package
        // Create a static void method called waitFor that accepts int as second to wait

    }

}

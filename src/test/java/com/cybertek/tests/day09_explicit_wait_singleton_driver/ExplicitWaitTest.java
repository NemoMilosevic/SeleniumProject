package com.cybertek.tests.day09_explicit_wait_singleton_driver;

import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ExplicitWaitTest extends TestBase {

    @Test
    public void testWaitForTitle(){

        // 1. navigate to https://practice.cybertekschool.com/dynamic_loading
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        // 2. click on Example 7
        driver.findElement(By.partialLinkText("Example 7")).click();

        // 3. Wait until the title value becomes "Dynamic title"
        // this is the way to create a WebDriverWait object with driver and max time to wait
        // ExpectedConditions class has pre-written conditions that can help
        // in the case below, we are checking for title that equals Dynamic title
        WebDriverWait wait = new WebDriverWait(driver,6);
        //wait.until(ExpectedConditions.titleIs("Dynamic title"));

        // 4. try different condition and wait until Sponge Bob image is visible on the screen
        // visibilityOfElementLocated accepts locator as parameter (and waits for 6 seconds)
        // we did static import above in order for our code to be shorter
        wait.until(visibilityOfElementLocated(By.xpath("//img[@alt='square pants']")));

        System.out.println("END");

        }

    @Test
    public void testByTextToBe(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        driver.findElement(By.partialLinkText("Example 7")).click();

        WebDriverWait wait = new WebDriverWait(driver,6);
        wait.until(visibilityOfElementLocated(By.xpath("//img[@alt='square pants']")));

        WebElement alertArea = driver.findElement(By.id("alert"));
        System.out.println("alertArea.getText() = " + alertArea.getText());

    }

}

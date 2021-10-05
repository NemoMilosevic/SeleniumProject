package com.cybertek.day04_common_elements_xpath_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatingRadioButtons {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        // print the size of all radio buttons
        List<WebElement> radioButtonGroup = driver.findElements(By.name("color"));
        System.out.println("radioButtonGroup.size() = " + radioButtonGroup.size());

        // identify blue radio button and check if selected
        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
        blueRadioButton.click(); // nothing will happen since this button is already checked

        WebElement redRadioButton = driver.findElement(By.id("red"));
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());
        redRadioButton.click();

        WebElement yellowRadioButton = driver.findElement(By.id("yellow"));
        System.out.println("yellowRadioButton.isSelected() = " + yellowRadioButton.isSelected());
        yellowRadioButton.click();

        WebElement blackRadioButton = driver.findElement(By.id("black"));
        System.out.println("blackRadioButton.isSelected() = " + blackRadioButton.isSelected());
        blackRadioButton.click();

        WebElement greenRadioButton = driver.findElement(By.id("green"));
        System.out.println("greenRadioButton.isSelected() = " + greenRadioButton.isSelected());
        System.out.println("greenRadioButton.isEnabled() = " + greenRadioButton.isEnabled());

        System.out.println("--------------------------------------------");

        // loop over all the elements (radio buttons) to print these: id, isSelected, isEnabled
        for (WebElement eachColorRadio : radioButtonGroup) {
            System.out.println("radioButton = " + eachColorRadio.getAttribute("id"));
            System.out.println("isSelected() = " + eachColorRadio.isSelected());
            System.out.println("isEnabled() = " + eachColorRadio.isEnabled());
            System.out.println("--------------------------------------------");
        }

        driver.quit();

    }
}

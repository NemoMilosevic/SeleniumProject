package com.cybertek.tests.day11_property_driver_faker_pom;

import com.cybertek.pages.W_AllOrdersPage;
import com.cybertek.pages.W_CommonArea;
import com.cybertek.pages.W_LoginPage;
import com.cybertek.pages.W_OrderPage;
import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.TestBase;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.*;

public class WebOrderPOMTest extends TestBase {

    @Test
    public void testLoginPage(){

        W_LoginPage loginPage = new W_LoginPage();

        loginPage.goTo();
        loginPage.login("abc", "test"); // wrong credentials
        assertTrue (loginPage.loginErrorMsgPresent());
        System.out.println("Login Error Message = " + loginPage.loginErrorMsgPresent());

    }

    @Test
    public void testAllOrdersPage(){

        // import from WLoginPage class in order to login first
        W_LoginPage loginPage = new W_LoginPage();

        loginPage.goTo();
        loginPage.login("Tester", "test");

        // check methods from WAllOrderPage class
        W_AllOrdersPage allOrderPage = new W_AllOrdersPage();

        allOrderPage.checkAllButton.click();
        BrowserUtility.waitFor(2);
        allOrderPage.uncheckAllButton.click();
        BrowserUtility.waitFor(2);
        assertTrue( allOrderPage.header.isDisplayed() );

        // print the size of all the headers from the list
        System.out.println("Header Size = " + allOrderPage.headerList.size());
        assertEquals(13,allOrderPage.headerList.size());

    }

    @Test
    public void testCommonArea(){

        W_LoginPage loginPage = new W_LoginPage();

        loginPage.goTo();
        loginPage.login("Tester", "test");

        W_CommonArea commonArea = new W_CommonArea();

        commonArea.viewAllOrdersTab.click();
        BrowserUtility.waitFor(2);

        commonArea.viewAllProductsTab.click();
        BrowserUtility.waitFor(2);

        commonArea.orderTab.click();
        BrowserUtility.waitFor(2);

        commonArea.logoutButton.click();
        BrowserUtility.waitFor(2);

    }

    @Test
    public void testOrderFlow(){

        W_LoginPage loginPage = new W_LoginPage();

        loginPage.goTo();
        loginPage.login("Tester", "test");

        W_CommonArea commonArea = new W_CommonArea();

        commonArea.orderTab.click();
        BrowserUtility.waitFor(2);

        W_OrderPage orderPage = new W_OrderPage();

        orderPage.quantityBox.sendKeys(Keys.BACK_SPACE + "10");
        orderPage.calculateButton.click();

        Faker faker = new Faker();
        orderPage.costumerNameBox.sendKeys(faker.name().fullName());
        orderPage.streetBox.sendKeys(faker.address().streetAddress());
        orderPage.cityBox.sendKeys(faker.address().city());
        orderPage.stateBox.sendKeys(faker.address().state());
        orderPage.zipBox.sendKeys(faker.address().zipCode());
        BrowserUtility.waitFor(2);
        orderPage.cardMasterCardRadioButton.click();
        orderPage.cardNumberBox.sendKeys(faker.finance().creditCard());
        orderPage.cardExpDateBox.sendKeys(faker.numerify("0#/0#"));
        BrowserUtility.waitFor(2);
        orderPage.processButton.click();
        BrowserUtility.waitFor(2);


    }

}

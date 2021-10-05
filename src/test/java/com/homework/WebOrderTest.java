package com.homework;

import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.Driver;
import com.cybertek.utility.TestBase;
import com.cybertek.utility.WebOrderUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.*;

public class WebOrderTest extends TestBase {

    // testing the methods that we created in WebOrderUtility and BrowserUtility classes

    @BeforeEach
    public void testSetUpAndLogin() {
        WebOrderUtility.openWebOrderApp();
        WebOrderUtility.login("Tester","test");
    }

    @AfterEach
    public void testQuitBrowser(){
        BrowserUtility.waitFor(2);
        WebOrderUtility.logout();
    }

    @Test
    public void testVerifyUsernameSelectSideBarIsAtOrderPage(){
        WebOrderUtility.verifyUsername("Tester");
        WebOrderUtility.selectSideBarTab("View all orders");
        WebOrderUtility.isAtOrderPage();
    }

    @Test
    public void testSelectAll(){
        WebOrderUtility.checkAll();
    }

    @Test
    public void testDeselectAll(){
        WebOrderUtility.uncheckAll();
    }

    @Test
    public void testGetAllProducts(){
        WebOrderUtility.getAllProducts();
        System.out.println("Unit Price for MyMoney = "
                + WebOrderUtility.getUnitPriceFromForm("MyMoney"));
        System.out.println("Discount from FamilyAlbum = "
                + WebOrderUtility.getDiscountFromForm("FamilyAlbum", 11));
        System.out.println("Total for ScreenSaver = "
                + WebOrderUtility.calculateTotal("ScreenSaver", 5));
    }

    @Test
    public void testGetDiscount(){
        System.out.println("Expected Discount = " + WebOrderUtility.getExpectedDiscount("MyMoney", 5));
    }

    @Test
    public void testAddressAndPaymentInfo(){
        WebOrderUtility.selectSideBarTab("Order");
        WebOrderUtility.enterAddressInfo();
        WebOrderUtility.enterPaymentInfo();
        WebOrderUtility.submitAndVerify();
        BrowserUtility.waitFor(5);
    }

}

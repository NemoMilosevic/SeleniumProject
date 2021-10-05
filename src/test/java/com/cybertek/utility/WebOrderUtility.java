package com.cybertek.utility;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebOrderUtility {

    // method to navigate to WebOrder login page
    public static void openWebOrderApp(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
    }

    // login method
    public static void login() {

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

        // username element by id: ctl00_MainContent_username
        // password element by id: ctl00_MainContent_password
        // login button element by id: ctl00_MainContent_login_button

    }

    // overloaded login method with 2 String parameters
    public static void login(String username, String password) {

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    // logout method
    public static void logout(){

        Driver.getDriver().findElement(By.id("ctl00_logout")).click();

    }

    // method for header title at the main page
    public static boolean isAtOrderPage(){

        boolean result = false;

        try{
            WebElement header = Driver.getDriver().findElement(By.xpath("//h2[normalize-space(.)='List of All Orders']"));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space(.)='List of All Orders']")));
            System.out.println("Element was successfully identified!");
            result = true;
        }catch (NoSuchElementException e){
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            System.out.println("No such element!");
        }

        return result;

    }

    // method to verify username
    public static boolean verifyUsername (String username){
        WebElement loginInfo = Driver.getDriver().findElement(By.xpath("//div[@class='login_info']"));
        String loginInfoText = loginInfo.getText();
        if (loginInfoText.contains("Tester")){
            System.out.println("Test Passed");
            return true;
        }else{
            System.out.println("Test Failed");
            return false;
        }
    }

    // method to select side-bar tab
    public static void selectSideBarTab(String tabName){
        if (tabName.equalsIgnoreCase("View all orders")){
            Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']/li[1]/a")).click();
        }else if (tabName.equalsIgnoreCase("View all products")){
            Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']/li[2]/a")).click();
        }else{
            Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']/li[3]/a")).click();
        }
    }

    // method to check if all checkboxes are selected
    public static boolean checkAll(){
        boolean result = false;
        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> list = Driver.getDriver().findElements(By.id("ctl00_MainContent_btnCheckAll"));
        for (WebElement each : list) {
            if (each.isSelected()){
                return true;
            }else{
                return false;
            }
        }
        return result;
    }

    // method to check if all checkboxes are de-selected
    public static boolean uncheckAll(){
        boolean result = false;
        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();
        List<WebElement> list = Driver.getDriver().findElements(By.id("ctl00_MainContent_btnUncheckAll"));
        for (WebElement each : list) {
            if (each.isSelected()){
                return true;
            }else{
                return false;
            }
        }
        return result;
    }

    // method to view all products (3 modules: MyMoney, FamilyAlbum, ScreenSaver)
    public static List<String> getAllProducts(){
        selectSideBarTab("View all products");
        String firstProduct = Driver.getDriver().findElement(By.xpath("//td[.='MyMoney']")).getText();
        String secondProduct = Driver.getDriver().findElement(By.xpath("//td[.='FamilyAlbum']")).getText();
        String thirdProduct = Driver.getDriver().findElement(By.xpath("//td[.='ScreenSaver']")).getText();
        List<String> allProducts = new ArrayList<>();
        allProducts.addAll(Arrays.asList(firstProduct,secondProduct,thirdProduct));
        System.out.println("All Products = " + allProducts);
        return allProducts;
    }

    // method to return the product price according to the name
    public static int getUnitPriceFromForm(String productName){
        selectSideBarTab("Order");

        WebElement productDropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productSelectObj = new Select(productDropDown);
        productSelectObj.selectByVisibleText(productName);

        WebElement priceBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
        return Integer.parseInt(priceBox.getAttribute("value"));
    }

    // method to return the product discount according to the name
    public static int getDiscountFromForm(String productName, int quantity) {
        selectSideBarTab("Order");

        WebElement productDropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productSelectObj = new Select(productDropDown);
        productSelectObj.selectByVisibleText(productName);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity+"");
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();

        WebElement discountBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
        return Integer.parseInt(discountBox.getAttribute("value"));
    }

    // method to return number from Total input box
    public static int calculateTotal(String productName, int quantity) {
        selectSideBarTab("Order");

        WebElement productDropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productSelectObj = new Select(productDropDown);
        productSelectObj.selectByVisibleText(productName);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity+"");
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();

        WebElement totalBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));
        return Integer.parseInt(totalBox.getAttribute("value"));
    }

    // method to return discount value
    public static int getExpectedDiscount(String productName, int quantity){
        selectSideBarTab("Order");

        WebElement productDropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productSelectObj = new Select(productDropDown);
        productSelectObj.selectByVisibleText(productName);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity+"");
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();

        WebElement discountBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount"));
        return Integer.parseInt(discountBox.getAttribute("value"));

    }

    // method to fill out the Address Information section
    public static void enterAddressInfo(){
        Faker faker = new Faker();

        WebElement nameBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        nameBox.sendKeys(faker.name().fullName());
        WebElement streetBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        streetBox.sendKeys(faker.address().streetAddress());
        WebElement cityBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        cityBox.sendKeys(faker.address().city());
        WebElement stateBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        stateBox.sendKeys(faker.address().state());
        WebElement zipCodeBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipCodeBox.sendKeys(faker.address().zipCode());
    }

    // method to fill out the Payment Information section
    public static void enterPaymentInfo(){
        Faker faker = new Faker();

        WebElement visaButton = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaButton.click();
        WebElement cardNumberBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumberBox.sendKeys(faker.numerify("###################"));
        WebElement expDateBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expDateBox.sendKeys(faker.numerify("##/##"));
    }

    // method to click the process button and verify if new order has been successfully added
    public static boolean submitAndVerify(){
        WebElement processButton = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();
        boolean result = false;
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[normalize-space(.)='New order has been successfully added.']"))) ;
            System.out.println("New order has been added");
            result = true ;
        }catch (TimeoutException e){
            System.out.println("Order has not been successfully added");
        }
        return result ;
    }

}
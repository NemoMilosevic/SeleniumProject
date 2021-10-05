package com.cybertek.tests.day12_pom_practice_review;

import com.cybertek.pages.LibDashboardPage;
import com.cybertek.pages.LibLoginPage;
import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;

public class LibraryTest extends TestBase {

    @Test
    public void testLogin(){

        LibLoginPage loginPage = new LibLoginPage();

        loginPage.goTo();
        loginPage.login("librarian47@library","Sdet2022*");

        BrowserUtility.waitFor(3);

        LibDashboardPage dashboardPage = new LibDashboardPage();

        System.out.println("dashboardPage.getUserCountText() = " + dashboardPage.getUserCountText());
        System.out.println("dashboardPage.getBookCountText() = " + dashboardPage.getBookCountText());
        System.out.println("dashboardPage.getBorrowedBookText() = " + dashboardPage.getBorrowedBookText());

    }

}

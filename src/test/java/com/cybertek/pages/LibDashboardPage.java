package com.cybertek.pages;

import com.cybertek.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibDashboardPage {

    @FindBy(id = "user_count")
    private WebElement usersCount;

    @FindBy(id = "book_count")
    private WebElement booksCount;

    @FindBy(id = "borrowed_books")
    private WebElement borrowedBooks;

    public LibDashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getUserCountText(){
        return usersCount.getText();
    }

    public String getBookCountText(){
        return booksCount.getText();
    }

    public String getBorrowedBookText(){
        return borrowedBooks.getText();
    }

}

package com.amazon.pages;

import com.amazon.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class addWishList extends BaseClass {


    public addWishList(WebDriver driver) {
        this.driver = driver;
    }

    By hover = By.id("nav-link-accountList");
    By create_a_wish_list = By.linkText("Create a Wish List");
    By verify_WishList_Window = By.id("a-popover-header-1");
    By list_name = By.id("list-name");
    By create_list_btn = By.id("wl-redesigned-create-list");
    By numLists = By.xpath("//div[@id='your-lists-nav']/div/a/div/div/div/span");
    By moreOptions = By.id("overflow-menu-popover-trigger");
    By manageList = By.id("editYourList");
    By deleteList = By.cssSelector("input.a-button-input");
    By confirmDelete = By.id("a-popover-header-4");
    By confirm = By.id("list-delete-confirm-announce");
    By wishListMenu = By.linkText("Your Wish List");

    public void moveOverSignIn(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(hover)).perform();
    }

   @Test
    public void addList(String listName){
        driver.findElement(create_a_wish_list).click();
        if(driver.findElement(verify_WishList_Window).isDisplayed()){
            driver.findElement(list_name).clear();
            driver.findElement(list_name).sendKeys(listName);
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(create_list_btn)));
            driver.findElement(create_list_btn).click();
        }
    }

    @Test
    public void getWishLists(){
        driver.findElement(wishListMenu).click();
        List<WebElement> lists = driver.findElements(numLists);
        for(WebElement eachList : lists){
            System.out.println("Available lists are : " + eachList.getText());
        }
        System.out.println("Total lists found are : " + lists.size());
    }
}
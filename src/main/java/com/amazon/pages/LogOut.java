package com.amazon.pages;

import com.amazon.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LogOut extends BaseClass {

    public LogOut(WebDriver driver) {
        this.driver=driver;
    }

    By signOutBtn = By.id("nav-item-signout");
    By hover = By.id("nav-link-accountList");

    public void signOut(){
        driver.findElement(signOutBtn).click();

    }

    public void moveOverSignOut(){
        System.out.println("driver is" + driver);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(hover)).perform();
    }

}

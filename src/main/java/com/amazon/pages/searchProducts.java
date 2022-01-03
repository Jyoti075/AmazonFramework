package com.amazon.pages;

import com.amazon.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class searchProducts extends BaseClass {

    public searchProducts(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.id("twotabsearchtextbox");
    By searchBtn = By.id("nav-search-submit-button");
    By categories_dropDown = By.id("searchDropdownBox");
    public void search(){
        Select select = new Select(driver.findElement(categories_dropDown));
        select.selectByIndex(9);
        driver.findElement(searchBox).sendKeys("Think and Grow Rich");
        driver.findElement(searchBtn).click();
    }
}


package com.amazon.pages;

import com.amazon.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn extends BaseClass {

    public LogIn(WebDriver driver) {
        this.driver = driver;
    }

    By signInBtn = By.id("nav-link-accountList");
    By email_id = By.id("ap_email");
    By continue_btn = By.id("continue");
    By password = By.id("ap_password");
    By submit_btn = By.id("signInSubmit");
    By user = By.id("nav-link-accountList-nav-line-1");

    public void signIn(String user,String passwd){
        driver.findElement(signInBtn).click();
        driver.findElement(email_id).sendKeys(user);
        driver.findElement(continue_btn).click();
        driver.findElement(password).sendKeys(passwd);
        driver.findElement(submit_btn).click();
    }

    public String getUser(){
        return driver.findElement(user).getText();
    }
}

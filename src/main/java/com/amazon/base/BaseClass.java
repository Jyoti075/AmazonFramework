package com.amazon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;

    @BeforeSuite
    public void initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("/Users/jyoti/IdeaProjects/Amazon_Framework/src/main/java/com/amazon/config/config.properties");
        prop.load(file);
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","//Users//jyoti//Downloads//chromedriver");
            driver = new ChromeDriver();

        }
        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","//Users//jyoti//Downloads//geckodriver");
            driver = new FirefoxDriver();
        }
        else if(browserName.equals("safari")){
            driver = new SafariDriver();
        }
    }

    public static WebDriver getDriver(){
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        return driver;
    }

   /* @AfterSuite
    public void tearDown(){
        driver.quit();
    }*/


}

package com.amazon.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Testcase " + result.getName() + "failed......");
        String methodName = result.getMethod().getMethodName();
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        takeScreenshot(methodName,driver);
    }

    public void takeScreenshot(String methodName,WebDriver driver){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty(("user.dir") + "/reports/" + methodName + ".jpg");
        try {
            FileUtils.copyFile(src,new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test has started.....");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test has completed....");
    }
}

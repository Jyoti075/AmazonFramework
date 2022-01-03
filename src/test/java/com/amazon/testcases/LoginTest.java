package com.amazon.testcases;

import com.amazon.base.BaseClass;
import com.amazon.pages.LogIn;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(dataProvider ="test-data")
    public void SignInTest(String user, String passwd) {
        LogIn login = new LogIn(getDriver());
        login.signIn(user,passwd);
        String expected_message = "Hello, " + user;
        String actual_message = login.getUser();
        Assert.assertEquals(actual_message,expected_message);
    }

    @DataProvider(name = "test-data")
    public Object[][] getTestData() {
        return new Object[][]{
                {"test1@gmail.com","testpassword"}
        };
    }
}

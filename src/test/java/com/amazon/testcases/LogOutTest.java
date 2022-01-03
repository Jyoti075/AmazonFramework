package com.amazon.testcases;

import com.amazon.base.BaseClass;
import com.amazon.pages.LogOut;
import org.testng.annotations.Test;

public class LogOutTest extends BaseClass {

    @Test
    public void SignOut(){
        LogOut logOut = new LogOut(getDriver());
        logOut.moveOverSignOut();
        logOut.signOut();
    }
}

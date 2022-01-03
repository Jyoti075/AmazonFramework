package com.amazon.testcases;

import com.amazon.base.BaseClass;
import com.amazon.pages.addWishList;
import com.amazon.utils.ReadTestData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddWishListTest extends BaseClass {

    String sheetName="name";

    //Creates a new wish list
    @Test(dataProvider = "excel-data")
    public void createWishList(String name) {
        addWishList createWishList = new addWishList(getDriver());
        createWishList.moveOverSignIn();
        createWishList.addList(name);
    }

    @DataProvider(name = "excel-data")
    public Object[][] getTestData() throws IOException {
        return ReadTestData.readTestData(sheetName);
    }

    @Test
    //Checks the number of lists
    public void PrintWishLists(){
        addWishList createWishList = new addWishList(getDriver());
        createWishList.moveOverSignIn();
        createWishList.getWishLists();
    }

}

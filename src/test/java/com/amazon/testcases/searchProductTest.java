package com.amazon.testcases;

import com.amazon.base.BaseClass;
import com.amazon.pages.searchProducts;
import org.testng.annotations.Test;

public class searchProductTest extends BaseClass {

    @Test
    public void search(){
        searchProducts search = new searchProducts(getDriver());
        search.search();
    }
}

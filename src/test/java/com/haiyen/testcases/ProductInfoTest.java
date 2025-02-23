package com.haiyen.testcases;

import com.haiyen.common.BaseTest;
import com.haiyen.helpers.ExcelHelper;
import com.haiyen.helpers.PropertiesHelper;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ProductInfoTest extends BaseTest {

    @Test(priority = 1)
    public void testGetProductInfo() {
        getLoginPage().openHomePage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("DataTest/GetProductInfo.xlsx", "ProductInfo");

        ArrayList<String> productInfo = getProductInfoPage().productInfo(PropertiesHelper.getValue("product_P01"));
        int lastRow = excelHelper.getLastRowNum();
        int newRow = lastRow + 1;
        excelHelper.setCellData(String.valueOf(newRow), newRow, 0);
        for (int i = 0; i < productInfo.size(); i++) {
            excelHelper.setCellData(productInfo.get(i), newRow, i + 1);
        }
    }
}

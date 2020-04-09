package com.weborders.tests;

import com.weborders.pages.LoginPage;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends AbstractBaseTest {

    @Test(dataProvider = "smokeTestData")
    public void smokeTest(String component,String expectedPageSubtitle){

        extentTest = extentReports.createTest("Verify"+component);
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        loginPage.navigateTo(component);
        assertEquals(loginPage.getPageSubtitleText(),expectedPageSubtitle);

        extentTest.pass(component+ "verified!");
    }

    @DataProvider
    public Object[][] smokeTestData(){
        return new String[][]{
                {"View all products","List of Products"},
                {"View all orders","List of All Orders"},
                {"Order","Order"}
        };

    }


}

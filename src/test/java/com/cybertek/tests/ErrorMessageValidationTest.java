package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.pages.ListingPage;
import com.cybertek.pages.PrestashopHomePage;
import com.cybertek.utilities.ConfiderationReader;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidationTest extends TestBase {

    @Test
    public void wrongEmailTest(){
        HomePage homePage = new HomePage();

        driver.get(ConfiderationReader.getProperty("url"));

        homePage.username.sendKeys("admin");
        homePage.password.sendKeys("test");
        homePage.loginButton.click();

        String error = "Invalid Login or Password.";
        String actualError = homePage.errorMessage.getText();

        Assert.assertEquals(actualError, error);
    }

    @Test
    public void wrongPasswordTest(){
        HomePage homePage = new HomePage();

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        homePage.username.sendKeys("Tester");
        homePage.password.sendKeys("wrong password");
        homePage.loginButton.click();

        String expextedError = "Invalid Login or Password.";
        String actualError = homePage.errorMessage.getText();
        Assert.assertEquals(actualError, expextedError);

    }

    @Test
    public void blankUsername(){
        HomePage homePage = new HomePage();

        homePage.open();
        homePage.login("", "test");

        String expextedError = "Invalid Login or Password.";
        String actualError = homePage.errorMessage.getText();
        Assert.assertEquals(actualError, expextedError);
    }


    // this is just a method which does not do anything
 @Test
    public void test(){
        ListingPage nilesLane = new ListingPage();

        ListingPage palmetLane = new ListingPage();

        PrestashopHomePage prestashopHomePage = new PrestashopHomePage();

        WebElement tshirt = prestashopHomePage.product("tshirt");

        WebElement dress = prestashopHomePage.product("dress");


    }








}
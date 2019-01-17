package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class MixedAnnotations {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        System.out.println("Setting up the driver here");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpTheMethod(){
        System.out.println("Opening a browser");
        driver = new ChromeDriver();
        System.out.println("go to website and login");
        driver.get("https://google.com");

    }

    @Test
    public void testOne(){
        System.out.println("Testing testing testing: account info");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("logout");
        System.out.println("closing browser");
        driver.quit();
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Reporting everything");
    }

    @Test
    public void testTwo(){
        System.out.println("Testing testing testing: payment");
    }

    @Test
    public void testThree(){
        System.out.println("Testing testing testing: another thing");
    }

}

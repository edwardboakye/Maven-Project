package com.cybertek.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ScrollTest extends TestBase {

    @Test
    public void test()throws InterruptedException{
        driver.get("https://youtube.com");

        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_UP).perform();

        Thread.sleep(5000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }



}

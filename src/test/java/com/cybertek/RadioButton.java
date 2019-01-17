package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class RadioButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");

        WebElement blue = driver.findElement(By.id("gwt-debug-cwRadioButton-color-blue-input"));
        WebElement red = driver.findElement(By.id("gwt-debug-cwRadioButton-color-red-input"));

        //verify blue checked, red not checked
        System.out.println("DEFAULT");
        System.out.println("blue: " + blue.isSelected());
        System.out.println("red: " + red.isSelected());
        //check blue
        blue.click();
        System.out.println("Clicking on blue");
        blue.click();
        // verify blue checked, red not checked
        System.out.println("blue: " + blue.isSelected());
        System.out.println("red: " + red.isSelected());
        // check red
        System.out.println("Clicking red");
        red.click();
        // verify blue not checked, red is checked
        System.out.println("blue: " + blue.isSelected());
        System.out.println("red: " + red.isSelected());
    }
}

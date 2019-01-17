package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
go to https://the-internet.herokuapp.com/forgot_password
verify enter email and submit
verify email sent message on the next page
"Your e-mail's been sent!"
 */

public class SubmitEmail {

    public static void main(String[] args) {

        // setting driver path for chrome using the webdriver manager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement input = driver.findElement(By.id("email"));

//        input.sendKeys("somemeail@somemail.com"+ Keys.ENTER);

        input.sendKeys("somemeail@somemail.com");
        input.submit();

        String expected = "Your email's been sent!";
        String actaul = driver.findElement(By.id("content")).getText();

        System.out.println(actaul);

        if(actaul.equals(expected)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actual = " + actaul);
            System.out.println("expected = " + expected);
        }

    }


}

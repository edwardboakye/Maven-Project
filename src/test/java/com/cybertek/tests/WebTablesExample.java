package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesExample extends TestBase {
    @Test
    public void printWholeTable(){
        login();
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }
    public void login(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
    }
    @Test
    public void printAllHeaders(){
        login();
        List<WebElement>headers = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for(WebElement header : headers){
            System.out.println(header.getText());
        }
    }
    @Test
    public void printRow(){
        login();
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
        System.out.println("number of rows: " + allRows.size());
        for(WebElement header : allRows){
            System.out.println(header.getText());
        }
        // print the nth
            System.out.println("printing row " + 4);
            System.out.println(allRows.get(3).getText());
    }
    // print

    @Test
    public void printTableSize(){
      login();
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
        System.out.println("number of rows: " + allRows.size());

        List<WebElement>allHeaders = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]/th"));
        System.out.println("number of columns: " + allHeaders.size());
    }

    /*
    print a row without using a list
     */

    @Test
    public void printRow2(){
        login();
        WebElement row = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[5]"));
        System.out.println(row.getText());
    }
    /*
       print all the cells of a a row whose index is given in the xpath
        */
    @Test
    public void printAllCellsInOneRow(){
        login();
        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[4]/td"));
        for(WebElement header : cells){
            System.out.println(header.getText());
        }
    }

    /*
  print by coordinates : based on row and column number
   */

    @Test
    public void printByCoordinates(){
        login();
        WebElement cell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[6]/td[11]"));
        System.out.println(cell.getText());
        System.out.println(getCell(6,11).getText());
    }

    public WebElement getCell(int row, int col){
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+"]/td["+col+"]";
        return driver.findElement(By.xpath(xpath));
    }
    //print all values in column
    @Test
    public void printColumn(){
       login();
       List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
       for(WebElement header : allNames){
           System.out.println(header.getText());
       }
    }
    //find the select checkbox for a given name
    @Test
    public void selectCheckbox(){
        login();
        WebElement checkbox = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[1]/input"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
    }

    //get a column name as a parameters and returns the index of the column name
    /*
    verify that name 'Mark Smith' exists in the names column
        verify that city 'Whitestone, British' exists in the cities column
  */
    @Test
    public void test(){
        login();
        int nameIndex = getColumnIndex("Name");
        System.out.println(nameIndex);
        List<WebElement>allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+nameIndex+"]"));
        boolean found = false;
        for(int i = 0; i<allNames.size(); i++){
            if(allNames.get(i).getText().equals("Mark Smith")){
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
        int cityIndex = getColumnIndex("City");
        List<WebElement>allCities = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+cityIndex+"]"));
        for (int i = 0; i<allCities.size(); i++){
            if(allCities.get(i).getText().equals("Whitestone British")){
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);

    }
    public int getColumnIndex(String column){
        List<WebElement>allHeader = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for(int i = 0; i<allHeader.size(); i++){
            if(allHeader.get(i).getText().equals(column)){
                return i + 1;
            }
        }
        return 0;
    }

}

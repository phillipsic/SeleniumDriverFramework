/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.*/
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author mkumar
 */
public class ModifyEmployeeContactCommon extends CommonMenu {

    public ModifyEmployeeContactCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Change Contact Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    /*  public void addEmployeeInfo() throws Exception {
          
          String firstName="manoj";
          ModifyContactInformationCommon modifyContactInfo;
          modifyContactInfo = new ModifyContactInformationCommon(driver);
          firstName = modifyContactInfo.getFirstName();
          System.out.println(firstName);
      
      }*/

    public String getFirstName() throws Exception {

        return driver.findElement(By.id("first_name")).getAttribute("value");
    }

    public String getLastName() throws Exception {

        return driver.findElement(By.id("last_name")).getAttribute("value");
    }

    public String getAddressLineOne() throws Exception {

        return driver.findElement(By.id("address_line_1")).getAttribute("value");
    }

    public String getAddressLineTwo() throws Exception {

        return driver.findElement(By.id("address_line_2")).getAttribute("value");
    }

    public String getAddressLineThree() throws Exception {

        return driver.findElement(By.id("address_line_3")).getAttribute("value");
    }

    public String getAddressLineFour() throws Exception {

        return driver.findElement(By.id("address_line_4")).getAttribute("value");
    }

    public String getZipCode() throws Exception {

        return driver.findElement(By.id("home_zip")).getAttribute("value");
    }

    public String getCity() throws Exception {

        return driver.findElement(By.id("home_city")).getAttribute("value");
    }

    public String getEmail() throws Exception {

        return driver.findElement(By.id("email")).getAttribute("value");
    }

    public String getPhoneNumber() throws Exception {

        return driver.findElement(By.id("home_phone")).getAttribute("value");
    }

    public String getFaxNumber() throws Exception {

        return driver.findElement(By.id("fax")).getAttribute("value");
    }

    public void enterFirstName(String FN) throws Exception {
        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys(FN);
    }

    public void enterLastName(String lastName) throws Exception {
        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys(lastName);

    }

    public void enterEmail(String eMail) throws Exception {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(eMail);
    }

    public void enterPhoneNumber(String phoneNumber) throws Exception {
        driver.findElement(By.id("home_phone")).clear();
        driver.findElement(By.id("home_phone")).sendKeys(phoneNumber);
    }

    public void enterFaxNumber(String faxNumber) throws Exception {
        driver.findElement(By.id("fax")).clear();
        driver.findElement(By.id("fax")).sendKeys(faxNumber);
    }

    public void enterAddressLineOne(String addressLineOne) throws Exception {
        driver.findElement(By.id("address_line_1")).clear();
        driver.findElement(By.id("address_line_1")).sendKeys(addressLineOne);
    }

    public void enterPostCode(String postCode) throws Exception {
        driver.findElement(By.id("home_zip")).clear();
        driver.findElement(By.id("home_zip")).sendKeys(postCode);
    }

    public void enterCity(String city) throws Exception {
        driver.findElement(By.id("home_city")).clear();
        driver.findElement(By.id("home_city")).sendKeys(city);
    }

    public ModifyEmployeeContactConfirmationCommon clickOk() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ModifyEmployeeContactConfirmationCommon(driver);
    }
}

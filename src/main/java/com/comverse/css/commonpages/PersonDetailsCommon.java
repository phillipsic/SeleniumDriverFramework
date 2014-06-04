/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PersonDetailsCommon extends CommonMenu {
    static String expectedScreen = "Account Details";

    public PersonDetailsCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickUpdate() throws Exception {
        driver.findElement(By.id("submitButton")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

    public void selectTitle(String value) throws Exception {
        new Select(driver.findElement(By.id("title"))).selectByVisibleText(value);
    }

    public void setFirstName(String value) throws Exception {
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(value);
    }

    public void setLastName(String value) throws Exception {
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(value);
    }

    public void setGender(String value) throws Exception {
        if (value == "female") {
            driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
        } else {
            driver.findElement(By.xpath("//input[@name='gender']")).click();
        }
    }

    public void setNationality(String value) throws Exception {
        new Select(driver.findElement(By.id("nationality"))).selectByVisibleText(value);
    }

    public void setLanguage(String value) throws Exception {
        new Select(driver.findElement(By.id("language"))).selectByVisibleText(value);
    }

    public void setEmailAddress(String value) throws Exception {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(value);
    }

    public void setPhoneNumber(String value) throws Exception {
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys(value);
    }

    public void setMobileNumber(String value) throws Exception {
        driver.findElement(By.id("mobile")).clear();
        driver.findElement(By.id("mobile")).sendKeys(value);
    }

    public void setFaxNumber(String value) throws Exception {
        driver.findElement(By.id("fax")).clear();
        driver.findElement(By.id("fax")).sendKeys(value);
    }

    public void setNationalID(String value) throws Exception {
        driver.findElement(By.id("nationalid")).clear();
        driver.findElement(By.id("nationalid")).sendKeys(value);
    }

    public void setDateOfBirth(String value) throws Exception {
        driver.findElement(By.id("dateOfBirth")).clear();
        driver.findElement(By.id("dateOfBirth")).sendKeys(value);
    }

    public void setAddressLine1(String value) throws Exception {
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys(value);
    }

    public void setPostCode(String value) throws Exception {
        driver.findElement(By.id("zipcode")).clear();
        driver.findElement(By.id("zipcode")).sendKeys(value);
    }

    public void setCity(String value) throws Exception {
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(value);
    }

    public void selectHomeCountry(String value) throws Exception {
        new Select(driver.findElement(By.id("country"))).selectByVisibleText(value);
    }

}

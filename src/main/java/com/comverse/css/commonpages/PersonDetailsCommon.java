/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class PersonDetailsCommon extends CommonMenu {
    static String expectedScreen = "Account Details";

    public PersonDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickUpdate() throws Exception {
        tool.driver.findElement(By.id("submitButton")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void selectTitle(String value) throws Exception {
        new Select(tool.driver.findElement(By.id("title"))).selectByVisibleText(value);
    }

    public void setFirstName(String value) throws Exception {
        tool.driver.findElement(By.id("firstName")).clear();
        tool.driver.findElement(By.id("firstName")).sendKeys(value);
    }

    public void setLastName(String value) throws Exception {
        tool.driver.findElement(By.id("lastName")).clear();
        tool.driver.findElement(By.id("lastName")).sendKeys(value);
    }

    public void setGender(String value) throws Exception {
        if (value == "female") {
            tool.driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
        } else {
            tool.driver.findElement(By.xpath("//input[@name='gender']")).click();
        }
    }

    public void setNationality(String value) throws Exception {
        new Select(tool.driver.findElement(By.id("nationality"))).selectByVisibleText(value);
    }

    public void setLanguage(String value) throws Exception {
        new Select(tool.driver.findElement(By.id("language"))).selectByVisibleText(value);
    }

    public void setEmailAddress(String value) throws Exception {
        tool.driver.findElement(By.id("email")).clear();
        tool.driver.findElement(By.id("email")).sendKeys(value);
    }

    public void setPhoneNumber(String value) throws Exception {
        tool.driver.findElement(By.id("phone")).clear();
        tool.driver.findElement(By.id("phone")).sendKeys(value);
    }

    public void setMobileNumber(String value) throws Exception {
        tool.driver.findElement(By.id("mobile")).clear();
        tool.driver.findElement(By.id("mobile")).sendKeys(value);
    }

    public void setFaxNumber(String value) throws Exception {
        tool.driver.findElement(By.id("fax")).clear();
        tool.driver.findElement(By.id("fax")).sendKeys(value);
    }

    public void setNationalID(String value) throws Exception {
        tool.driver.findElement(By.id("nationalid")).clear();
        tool.driver.findElement(By.id("nationalid")).sendKeys(value);
    }

    public void setDateOfBirth(String value) throws Exception {
        tool.driver.findElement(By.id("dateOfBirth")).clear();
        tool.driver.findElement(By.id("dateOfBirth")).sendKeys(value);
    }

    public void setAddressLine1(String value) throws Exception {
        tool.driver.findElement(By.id("address1")).clear();
        tool.driver.findElement(By.id("address1")).sendKeys(value);
    }

    public void setPostCode(String value) throws Exception {
        tool.driver.findElement(By.id("zipcode")).clear();
        tool.driver.findElement(By.id("zipcode")).sendKeys(value);
    }

    public void setCity(String value) throws Exception {
        tool.driver.findElement(By.id("city")).clear();
        tool.driver.findElement(By.id("city")).sendKeys(value);
    }

    public void selectHomeCountry(String value) throws Exception {
        new Select(tool.driver.findElement(By.id("country"))).selectByVisibleText(value);
    }

}

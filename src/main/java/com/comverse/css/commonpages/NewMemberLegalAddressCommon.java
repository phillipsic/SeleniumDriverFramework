/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class NewMemberLegalAddressCommon extends CommonMenu {

    public NewMemberLegalAddressCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "New Member - Legal Address";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setFirstName(String firstName) throws Exception {

        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys(firstName);
    }

    public void setLastName(String lastName) throws Exception {

        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys(lastName);
    }

    public LoginCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        return new LoginCommon(driver);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

/**
 * 
 * @author cchadai
 */
public class ConfigureServiceConnectionDetails extends B2CMenu {

    public ConfigureServiceConnectionDetails(WebDriver driver) {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Configure Service Connection Details";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyBasket(driver);
    }

    public void setServiceConnectionEmail(String Email) throws Exception {

        // driver.findElement(By.id("inputFields1180")).clear();
        // driver.findElement(By.id("inputFields1180")).sendKeys(Email);

        driver.findElement(By.xpath(".//span[contains(text(), 'Enter your Email address:')]/../../div[2]/input")).clear();
        driver.findElement(By.xpath(".//span[contains(text(), 'Enter your Email address:')]/../../div[2]/input")).sendKeys(Email);

    }
}

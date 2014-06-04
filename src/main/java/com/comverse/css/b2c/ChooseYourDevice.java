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
 * @author iphilli
 */
public class ChooseYourDevice extends B2CMenu {

    public ChooseYourDevice(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Choose Your Device";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public EnterYourSubscriptionDetails clickNoThanks() throws Exception {

        driver.findElement(By.xpath("//input[@value='No Thanks']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(driver);
    }

}

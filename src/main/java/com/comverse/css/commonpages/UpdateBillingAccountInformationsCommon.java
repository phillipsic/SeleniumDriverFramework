/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author cchadai
 */
public class UpdateBillingAccountInformationsCommon extends CommonMenu {

    public UpdateBillingAccountInformationsCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Update administrative account information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public EnterIdentificationDataCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new EnterIdentificationDataCommon(driver);
    }

}

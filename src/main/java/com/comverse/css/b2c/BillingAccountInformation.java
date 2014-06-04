/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class BillingAccountInformation extends B2CMenu {

    public BillingAccountInformation(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Billing Account Information";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

}

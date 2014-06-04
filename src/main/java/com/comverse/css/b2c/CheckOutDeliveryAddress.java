/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class CheckOutDeliveryAddress extends B2CMenu {

    

    public CheckOutDeliveryAddress(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Checkout - Delivery Address";

     
        if (!expectedScreen.equals(driver.getTitle())) {
     
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckOutBillingAccountInformation clickContinue() throws Exception {

        driver.findElement(By.id("nav_next_page")).click();
        return new CheckOutBillingAccountInformation(driver);
    }

}

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
public class CheckoutDeliveryAddressCommon extends CommonMenu {

    public CheckoutDeliveryAddressCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Checkout - Delivery Address";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutReviewCommon clickNextPage() throws Exception {
        driver.findElement(By.id("nav_next_page")).click();
        return new CheckoutReviewCommon(driver);
    }

}

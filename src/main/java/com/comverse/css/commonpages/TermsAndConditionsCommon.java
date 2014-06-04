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
public class TermsAndConditionsCommon extends CommonMenu {

    public TermsAndConditionsCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Terms and Conditions";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutDeliveryAddressCommon clickAccept() throws Exception {

        driver.findElement(By.xpath("//input[@value='Accept']")).click();
        return new CheckoutDeliveryAddressCommon(driver);
    }
}

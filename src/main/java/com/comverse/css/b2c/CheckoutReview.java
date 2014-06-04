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
public class CheckoutReview extends B2CMenu {
   

    public CheckoutReview(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Checkout Review";

       
        if (!expectedScreen.equals(this.driver.getTitle())) {
   
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutConfirmation clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new CheckoutConfirmation(driver);
    }
    
    public ImmediatePayment clickContinueWithDevices() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ImmediatePayment(driver);
    }

}

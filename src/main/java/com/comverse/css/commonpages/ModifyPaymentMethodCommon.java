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
public class ModifyPaymentMethodCommon extends CommonMenu {

    public ModifyPaymentMethodCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Modify payment method";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AccountDetailsCommon(driver);
    }
}

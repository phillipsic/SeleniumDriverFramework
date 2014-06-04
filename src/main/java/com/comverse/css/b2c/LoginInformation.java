/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author iphilli
 */
public class LoginInformation extends B2CMenu {

    public LoginInformation(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Login Information";


        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public LockLogin clickLockLogin() throws Exception {

        driver.findElement(By.linkText("Lock Login")).click();
        Common.sleepForNumberOfSeconds(1);
        return new LockLogin(driver);
    }

   
}

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
public class LockLogin extends B2CMenu {

    public LockLogin(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Lock Login";


        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.sleepForNumberOfSeconds(1);
       
    }

   
}

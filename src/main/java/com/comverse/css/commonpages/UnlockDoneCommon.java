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
public class UnlockDoneCommon extends CommonMenu {

    public UnlockDoneCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Unlock done";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ModifyLoginPasswordCommon clickChangePassword() throws Exception {

        driver.findElement(By.xpath("//input[@value='Change Password']")).click();
        return new ModifyLoginPasswordCommon(driver);
    }

}

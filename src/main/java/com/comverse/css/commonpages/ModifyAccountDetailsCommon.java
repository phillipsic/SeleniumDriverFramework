/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

/**
 * 
 * @author iphilli
 */
public class ModifyAccountDetailsCommon extends CommonMenu {

    public ModifyAccountDetailsCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Modify Account Details";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectCheck() throws Exception {

        driver.findElement(By.xpath("(//input[@name='method'])[2]")).click();

    }

    public ShoppingCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new ShoppingCommon(driver);
    }
}

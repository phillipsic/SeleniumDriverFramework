/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author mkumar
 */
public class ModifyEmployeeContactConfirmationCommon extends CommonMenu {

    public ModifyEmployeeContactConfirmationCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Confirm Contact Information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ModifyEmpContactConfCommon clickOk() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ModifyEmpContactConfCommon(driver);
    }

}

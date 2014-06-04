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
public class UnlockLoginCommon extends CommonMenu {

    public UnlockLoginCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Unlock Login";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public UnlockDoneCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new UnlockDoneCommon(driver);
    }
    
    public LoginInformationCommon clickOK() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new LoginInformationCommon(driver);
    }

}

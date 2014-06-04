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
public class LockLoginCommon extends CommonMenu {

    public LockLoginCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Lock Login";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
    }

    public UnlockLoginCommon clickConfirmUnlock() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new UnlockLoginCommon(driver);
    }

    public LoginInformationCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new LoginInformationCommon(driver);
    }
}

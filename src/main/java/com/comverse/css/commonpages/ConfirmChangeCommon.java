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
public class ConfirmChangeCommon extends CommonMenu {

    public ConfirmChangeCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Confirm change";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public LoginInformationCommon clickOK() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new LoginInformationCommon(driver);
    }

}

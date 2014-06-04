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
public class ConfirmNewSecretAnswerCommon extends CommonMenu {

    public ConfirmNewSecretAnswerCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Confirm new secret question and answer";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfirmChangeCommon clickOK() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ConfirmChangeCommon(driver);
    }

}

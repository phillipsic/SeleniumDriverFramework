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
public class ResumeBasketConfirmCommon extends CommonMenu {

    public ResumeBasketConfirmCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Resume Basket Confirm";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new MyBasketCommon(driver);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

/**
 * 
 * @author Koushic
 */
public class SwapImpact extends B2CMenu {

    public SwapImpact(WebDriver driver) {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Swap Impact";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public MyBasket clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='Ok']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyBasket(driver);
    }

    public ConfigureBalance clickOkExpectingConfigureBalance() throws Exception {

        driver.findElement(By.xpath("//input[@value='Ok']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ConfigureBalance(driver);
    }

}

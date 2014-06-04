/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author gmaroth
 */
public class RechargeSubscriberCommon extends CommonMenu {

    public RechargeSubscriberCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Recharge Subscriber";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getRechargeClass() throws Exception {

        String rechargeClass = driver.findElement(By.xpath("//tr[4]/td[2]/span/strong")).getText();

        return rechargeClass;
    }

    public ViewBalanceCommon clickViewBalances() throws Exception {

        driver.findElement(By.id("youcan_BACK_TO_BALANCE_VIEW")).click();

        return new ViewBalanceCommon(driver);
    }
}

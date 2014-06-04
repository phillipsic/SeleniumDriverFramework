/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class ViewTransactionHistoryCommon extends CommonMenu {
    static String expectedScreen = "View transaction history";

    public ViewTransactionHistoryCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " +expectedScreen+ " , but got: " + currentScreen);
        }
    }

    public ViewUsageHistoryCommon clickOnUsageHistory() throws Exception {
        driver.findElement(By.id("youcan_USAGE_HISTORY")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewUsageHistoryCommon(driver);
    }

    public ViewMTRHistoryCommon clickonMTRHistory() throws Exception {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("youcan_MTR_HISTORY")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewMTRHistoryCommon(driver);
    }

    public ViewRCHistoryCommon clickonRCHistory() throws Exception {
        driver.findElement(By.id("youcan_RC_HISTORY")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewRCHistoryCommon(driver);
    }

    public ViewNRCHistoryCommon clickonNRCHistory() throws Exception {
        driver.findElement(By.id("youcan_NRC_HISTORY")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewNRCHistoryCommon(driver);
    }

    public ViewCombinedHistoryCommon clickonCombinedHistory() throws Exception {
        driver.findElement(By.id("youcan_COMBINED_HISTORY")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewCombinedHistoryCommon(driver);
    }
}

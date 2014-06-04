package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class UnbilledTransactionCommon extends CommonMenu {

    public UnbilledTransactionCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "View Unbilled Transactions";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewUnbilledRCNRCCommon clickUnbilledRCNRC() throws Exception {

        driver.findElement(By.id("youcan_VIEW_RC_NRC")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewUnbilledRCNRCCommon(driver);
    }

    public ViewUnbilledUsageCommon clickUnbilledUsage() throws Exception {

        driver.findElement(By.id("youcan_VIEW_USAGES")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewUnbilledUsageCommon(driver);
    }

    public ViewUnbilledMTRCommon clickUnbilledMTR() throws Exception {

        driver.findElement(By.id("youcan_VIEW_MTR")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewUnbilledMTRCommon(driver);
    }

    public ViewUnbilledRechargeCommon clickUnbilledRecharge() throws Exception {

        driver.findElement(By.id("youcan_VIEW_RECHARGES")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewUnbilledRechargeCommon(driver);
    }

    public ViewUnbilledAdjustmentCommon clickUnbilledAdjustment() throws Exception {

        driver.findElement(By.id("youcan_VIEW_ADJUSTMENTS")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewUnbilledAdjustmentCommon(driver);
    }

}

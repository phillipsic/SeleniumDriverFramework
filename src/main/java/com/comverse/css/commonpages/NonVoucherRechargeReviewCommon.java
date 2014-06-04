/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

/**
 * 
 * @author gmaroth
 */
public class NonVoucherRechargeReviewCommon extends CommonMenu {

    public NonVoucherRechargeReviewCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Non voucher recharge review";

        // Check that we're on the right page.
        if (!"Non voucher recharge review".equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RechargeSubscriberCommon confirmNonVoucherRecharge() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new RechargeSubscriberCommon(driver);
    }

    public RechargeSubscriberCommon confirmNonVoucherRechargeByCreditCard() throws Exception {

        driver.findElement(By.xpath("//input[@name='select']")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new RechargeSubscriberCommon(driver);
    }
}

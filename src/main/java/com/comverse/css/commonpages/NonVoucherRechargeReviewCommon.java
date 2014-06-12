/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class NonVoucherRechargeReviewCommon extends CommonMenu {

    public NonVoucherRechargeReviewCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Non voucher recharge review";

        // Check that we're on the right page.
        if (!"Non voucher recharge review".equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RechargeSubscriberCommon confirmNonVoucherRecharge() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new RechargeSubscriberCommon(tool, test, user);
    }

    public RechargeSubscriberCommon confirmNonVoucherRechargeByCreditCard() throws Exception {

        tool.driver.findElement(By.xpath("//input[@name='select']")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new RechargeSubscriberCommon(tool, test, user);
    }
}

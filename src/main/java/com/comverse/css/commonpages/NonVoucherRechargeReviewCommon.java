/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class NonVoucherRechargeReviewCommon extends CommonMenu {

    public NonVoucherRechargeReviewCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Non voucher recharge review";

        // Check that we're on the right page.
        if (!"Non voucher recharge review".equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RechargeSubscriberCommon confirmNonVoucherRecharge() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new RechargeSubscriberCommon(tool, test, user);
    }

    public RechargeSubscriberCommon confirmNonVoucherRechargeByCreditCard() throws Exception {

        tool.clickUsingXPath(tool, "//input[@name='select']");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new RechargeSubscriberCommon(tool, test, user);
    }
}

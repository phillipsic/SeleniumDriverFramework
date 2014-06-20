/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RechargeWithVoucherCommon extends CommonMenu {

    public RechargeWithVoucherCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Recharge with voucher";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterVoucherNumber(String voucherNumber) throws Exception {
        
        tool.enterStringUsingId("pkgnumber", voucherNumber);
    }

    public RechargeSubscriberCommon clickContinue() throws Exception {
        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RechargeSubscriberCommon(tool, test, user);
    }

}

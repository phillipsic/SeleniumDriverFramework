/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RechargeSubscriberCommon extends CommonMenu {

    public RechargeSubscriberCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Recharge Subscriber";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public String getRechargeClass() throws Exception {  test.writeInLog(Common.getMethodName());

        String rechargeClass = tool.getTextUsingXPath("//tr[4]/td[2]/span/strong");

        return rechargeClass;
    }

    public ViewBalanceCommon clickViewBalances() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_BACK_TO_BALANCE_VIEW");

        return new ViewBalanceCommon(tool, test, user);
    }
}

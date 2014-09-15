/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class OfferCancellationCommon extends CommonMenu {

    public OfferCancellationCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Offer Cancellation";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public AccountDetailsCommon clickOk() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("(//input[@value='OK'])");
        return new AccountDetailsCommon(tool, test, user);
    }

    public SubscriberDetailsCommon clickOkGoToSubscriberDashboard() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("(//input[@value='OK'])");
        return new SubscriberDetailsCommon(tool, test, user);
    }
}

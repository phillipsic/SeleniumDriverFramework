/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CheckoutReview extends B2CMenu {

    public CheckoutReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Checkout Review";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public CheckoutConfirmation clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckoutConfirmation(tool, test, user);
    }

    public ImmediatePayment clickContinueWithDevices() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ImmediatePayment(tool, test, user);
    }

}

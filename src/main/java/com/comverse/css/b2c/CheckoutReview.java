/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CheckoutReview extends B2CMenu {

    public CheckoutReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Checkout Review";

        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutConfirmation clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new CheckoutConfirmation(tool, test, user);
    }

    public ImmediatePayment clickContinueWithDevices() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new ImmediatePayment(tool, test, user);
    }

}

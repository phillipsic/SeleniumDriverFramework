/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class TermsAndConditionsCommon extends CommonMenu {

    public TermsAndConditionsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Terms and Conditions";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public CheckoutDeliveryAddressCommon clickAccept() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Accept']");
        return new CheckoutDeliveryAddressCommon(tool, test, user);
    }
}

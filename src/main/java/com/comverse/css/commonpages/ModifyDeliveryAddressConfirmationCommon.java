/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyDeliveryAddressConfirmationCommon extends CommonMenu {

    public ModifyDeliveryAddressConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Delivery Address - Confirmation";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public DeliveryAddressesCommon clickOk() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");
        return new DeliveryAddressesCommon(tool, test, user);
    }
}

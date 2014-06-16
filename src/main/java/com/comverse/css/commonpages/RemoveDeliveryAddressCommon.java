/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RemoveDeliveryAddressCommon extends CommonMenu {

    public RemoveDeliveryAddressCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Remove Delivery Address";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public DeliveryAddressesCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new DeliveryAddressesCommon(tool, test, user);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CheckoutConfirmation extends B2CMenu {

    public CheckoutConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Checkout Confirmation";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SearchOrders clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new SearchOrders(tool, test, user);
    }

    public Shopping clickOkExpectingShopping() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new Shopping(tool, test, user);
    }

    public String getOrderNumberFromPage() throws Exception {
        String orderNumber;

        orderNumber = tool.getTextUsingXPath(tool, "//span[2]");
        System.out.println("Order Number = '" + orderNumber + "'");

        return orderNumber;
    }

}

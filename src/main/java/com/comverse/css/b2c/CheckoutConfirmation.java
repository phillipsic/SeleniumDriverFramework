/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CheckoutConfirmation extends B2CMenu {

    public CheckoutConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Checkout Confirmation";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public SearchOrders clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        return new SearchOrders(tool, test, user);
    }

    public Shopping clickOkExpectingShopping() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        return new Shopping(tool, test, user);
    }

    public String getOrderNumberFromPage() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String orderNumber;
        orderNumber = tool.getTextUsingXPath("//span[2]");
        System.out.println("Order Number = '" + orderNumber + "'");
        return orderNumber;
    }

}

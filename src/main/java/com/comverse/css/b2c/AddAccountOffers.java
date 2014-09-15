/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddAccountOffers extends B2CMenu {

    public AddAccountOffers(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Account Offers";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public SubscriberDetail clickOk() throws Exception {  test.writeInLog(Common.getMethodName());
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetail(tool, test, user);
    }

    public String getAOOrderNumberFromPage() throws Exception {  test.writeInLog(Common.getMethodName());
        String orderNumber;
        test.writeInLog(Common.getMethodName());
        orderNumber = tool.getTextUsingXPath("//div[@class='txt']/span");
        orderNumber = orderNumber.substring(orderNumber.lastIndexOf(' ') + 1).replace(".", "");
        System.out.println("Order Number = '" + orderNumber + "'");

        return orderNumber;
    }

}

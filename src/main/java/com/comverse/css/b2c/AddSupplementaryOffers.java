package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddSupplementaryOffers extends B2CMenu {

    public AddSupplementaryOffers(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Supplementary Offers";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public SubscriberDetail clickOK() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        return new SubscriberDetail(tool, test, user);

    }

    public String getOrderNumberFromPage() throws Exception {
        String orderNumber;
        test.writeInLog(Common.getMethodName());
        orderNumber = tool.getTextUsingXPath("//span[1]");
        String temp[];
        temp = orderNumber.split("number");
        orderNumber = temp[1].replace(".", "");
        orderNumber = orderNumber.replace(" ", "");

        System.out.println("Order Number = '" + orderNumber + "'");
        return orderNumber;
    }
}

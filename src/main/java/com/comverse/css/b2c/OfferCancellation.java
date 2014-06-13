package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class OfferCancellation extends B2CMenu {

    public OfferCancellation(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Offer Cancellation";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberDetail ClickOk() throws Exception {
        tool.clickUsingCssSelector(tool, "input[type='submit'][value='OK']");
        return new SubscriberDetail(tool, test, user);
    }

    public String getOrderNumberFromPage() throws Exception {
        String orderNumber;

        orderNumber = tool.getTextUsingXPath(tool, "//span[1]");
        String temp[];
        temp = orderNumber.split("number");
        orderNumber = temp[1].replace(".", "");
        orderNumber = orderNumber.replace(" ", "");

        System.out.println("Order Number = '" + orderNumber + "'");
        return orderNumber;
    }

}

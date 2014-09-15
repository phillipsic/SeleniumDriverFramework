package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CheckoutConfirmationCommon extends CommonMenu {

    public CheckoutConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Checkout Confirmation";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public WorkSpaceCommon clickOk() throws Exception {  test.writeInLog(Common.getMethodName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new WorkSpaceCommon(tool, test, user);
    }

    public AccountDetailsCommon clickOkExpectingAccountDashboard() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public SubscriberDetailsCommon clickOkExpectingSubscriberDashboard() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);
    }

    public String getOrderNumberFromPage() throws Exception {  test.writeInLog(Common.getMethodName());
        String orderNumber;
        // String temp[];
        // String str = tool.getPageSource();
        // temp = str.split("Order Number:");
        // temp = temp[1].split("</span>");
        // temp = temp[0].split("<span>");
        // orderNumber = temp[1];

        orderNumber = tool.getTextUsingXPath("//*[@id=\"mainContents\"]/div/div/div[2]/div/div/span[2]");
        System.out.println("Order Number = '" + orderNumber + "'");
        return orderNumber;
    }

    public String getNCAOrderNumberFromPage() throws Exception {  test.writeInLog(Common.getMethodName());
        String orderNumber;
        // String temp[];
        // String str = tool.getPageSource();
        // temp = str.split("Order Number:");
        // temp = temp[1].split("</span>");
        // temp = temp[0].split("<span>");
        // orderNumber = temp[1];

        orderNumber = tool.getTextUsingXPath("//span[2]");
        System.out.println("Order Number = '" + orderNumber + "'");
        return orderNumber;
    }
}

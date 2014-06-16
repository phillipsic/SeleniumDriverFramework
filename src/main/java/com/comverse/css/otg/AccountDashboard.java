package com.comverse.css.otg;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.MyshapeCommon;

public class AccountDashboard extends MyshapeCommon {

    public AccountDashboard(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "account";
        for (String currentScreenSplitted : currentScreen.split("/")) {
            currentScreen = currentScreenSplitted;
        }

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void verifyPageWelcome() throws Exception {
        Common.assertTextOnPage(tool, "Welcome");
    }

    public SubscriberDashboard enterFirstSubscriber(String subscriberID) throws Exception {
        tool.clickUsingCssSelector(tool, "span.glyphicon.glyphicon-chevron-right");
        System.out.println("Enter first Subscriber");
        Thread.sleep(1000);
        return new SubscriberDashboard(tool, test, user, subscriberID);
    }

    public SubscriberDashboard enterThirdSubscriber(String subscriberID) throws Exception {
        tool.clickUsingXPath(tool, "//div[3]/div/h4/a/span");
        System.out.println("Enter third Subscriber");
        Thread.sleep(1000);
        return new SubscriberDashboard(tool, test, user, subscriberID);
    }

    public void clickFirstSubscriber() throws Exception {
        tool.clickUsingXPath(tool, "//div[4]/div/div/h4");
        System.out.println("click first Subscriber");
        Thread.sleep(1000);
    }

    public void clickSecondSubscriber() throws Exception {
        tool.clickUsingXPath(tool, "//div[4]/div[2]/div/h4");
        System.out.println("click second Subscriber");
        Thread.sleep(1000);
    }

    public void clickThirdSubscriber() throws Exception {
        tool.clickUsingXPath(tool, "//div[3]/div/h4");
        System.out.println("click third Subscriber");
        Thread.sleep(1000);
    }

    public MyBills clickMyBills() throws Exception {
        tool.clickUsingXPath(tool, "(//button[@type='button'])[2]");
        System.out.println("Enter MyBills");
        Thread.sleep(1000);
        return new MyBills(tool, test, user);
    }
}
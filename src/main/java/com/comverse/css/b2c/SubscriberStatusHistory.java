package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SubscriberStatusHistory extends B2CMenu {

    public SubscriberStatusHistory(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Subscriber Status History";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberDetail clickOk() throws Exception {

        tool.clickUsingXPath("//input[@value='OK']");
        // Common.waitForEndOfWaitingPage(tool,
        // this.getClass().getSimpleName());
        return new SubscriberDetail(tool, test, user);
    }

    public String getStatus() throws Exception {
        String subscriberStatus;
        subscriberStatus = tool.getTextUsingXPath("//td[2]");
        return subscriberStatus;

    }

}

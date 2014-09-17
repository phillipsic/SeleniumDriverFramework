package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SubscriberStatusHistory extends B2CMenu {

    public SubscriberStatusHistory(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Subscriber Status History";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public SubscriberDetail clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        // Common.waitForEndOfWaitingPage(tool,
        // this.getClass().getSimpleName());
        return new SubscriberDetail(tool, test, user);
    }

    public String getStatus() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String subscriberStatus;
        subscriberStatus = tool.getTextUsingXPath("//td[2]");
        return subscriberStatus;

    }

}

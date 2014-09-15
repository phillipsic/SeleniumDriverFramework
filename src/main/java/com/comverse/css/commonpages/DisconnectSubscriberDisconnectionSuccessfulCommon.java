package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class DisconnectSubscriberDisconnectionSuccessfulCommon extends CommonMenu {

    public DisconnectSubscriberDisconnectionSuccessfulCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Disconnect subscriber - Disconnection successful";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public SubscriberDetailsCommon clickOK() throws Exception {

        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new SubscriberDetailsCommon(tool, test, user);
    }
}

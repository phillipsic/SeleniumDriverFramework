package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class DisconnectSubscriberCommon extends CommonMenu {

    public DisconnectSubscriberCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Disconnect subscriber";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public DisconnectSubscriberDisconnectionSuccessfulCommon clickConfirm() throws Exception {

        tool.clickUsingXPath("//input[@value='Confirm']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new DisconnectSubscriberDisconnectionSuccessfulCommon(tool, test, user);
    }
}

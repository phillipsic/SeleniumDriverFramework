package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class DisconnectSubscriberImpactsCommon extends CommonMenu {

    public DisconnectSubscriberImpactsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Disconnect subscriber - Impacts";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public DisconnectSubscriberCommon clickConfirm() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Confirm']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new DisconnectSubscriberCommon(tool, test, user);
    }
}

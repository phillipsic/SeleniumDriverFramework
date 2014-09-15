package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SuspendSubscriberRequestForDetailsCommon extends CommonMenu {
    static String expectedScreen = "Suspend subscriber - Request for details";

    public SuspendSubscriberRequestForDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setReason(String reason) throws Exception {

        tool.selectVisibleTextByID("reason", reason);
    }

    public void setAnnotation(String annotation) throws Exception {

        
        tool.enterStringUsingId("annotation", annotation);
    }

    public SuspendSubscriberConfirmationCommon clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new SuspendSubscriberConfirmationCommon(tool, test, user);
    }
}

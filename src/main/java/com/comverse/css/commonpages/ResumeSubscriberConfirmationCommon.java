package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ResumeSubscriberConfirmationCommon extends CommonMenu {

    public ResumeSubscriberConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Resume subscriber - Confirmation";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public ResumeSubscriberResumeSuccessfulCommon clickConfirm() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Confirm']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ResumeSubscriberResumeSuccessfulCommon(tool, test, user);
    }
}

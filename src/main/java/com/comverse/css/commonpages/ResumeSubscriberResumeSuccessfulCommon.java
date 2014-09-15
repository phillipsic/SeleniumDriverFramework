package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ResumeSubscriberResumeSuccessfulCommon extends CommonMenu {

    public ResumeSubscriberResumeSuccessfulCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Resume subscriber - Resume successful";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public SubscriberDetailsCommon clickOK() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new SubscriberDetailsCommon(tool, test, user);
    }
}

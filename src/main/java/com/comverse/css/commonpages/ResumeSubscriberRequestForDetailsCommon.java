package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ResumeSubscriberRequestForDetailsCommon extends CommonMenu {
    static String expectedScreen = "Resume subscriber - Request for details";

    public ResumeSubscriberRequestForDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void clickCheckBoxResumeNow() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("propertyNow");

    }

    public void setReason(String reason) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.selectVisibleTextByID("reason", reason);
    }

    public void setAnnotation(String annotation) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("annotation", annotation);
    }

    public ResumeSubscriberConfirmationCommon clickContinue() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ResumeSubscriberConfirmationCommon(tool, test, user);
    }
}

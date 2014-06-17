package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class UnlockSubscriberRequestForDetailsCommon extends CommonMenu {
    static String expectedScreen = "Unlock subscriber - Request for details";

    public UnlockSubscriberRequestForDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickCheckBoxUnlockNow() throws Exception {

        tool.clickUsingID(tool, "propertyNow");

    }

    public void setReason(String reason) throws Exception {

        tool.selectVisibleTextByID(tool, "reason", reason);
    }

    public void setAnnotation(String annotation) throws Exception {

        
        tool.enterStringUsingId(tool, "annotation", annotation);
    }

    public UnlockSubscriberConfirmationCommon clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new UnlockSubscriberConfirmationCommon(tool, test, user);
    }
}

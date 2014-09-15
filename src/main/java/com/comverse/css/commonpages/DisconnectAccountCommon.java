package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class DisconnectAccountCommon extends CommonMenu {

    static String expectedScreen = "Disconnect account";

    public DisconnectAccountCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void clickCheckBoxUnlockNow() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingID("propertyNow");
    }

    public void clickCheckBoxDisconnectNow() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingID("disconnectNow");
    }

    public void setReason(String reason) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("reason", reason);
    }

    public void setAnnotation(String annotation) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.enterStringUsingId("annotation", annotation);
    }

    public DisconnectAccountCommon clickContinue() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new DisconnectAccountCommon(tool, test, user);
    }

    public DisconnectAccountCommon clickContinueOnImpacts() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new DisconnectAccountCommon(tool, test, user);
    }

    public AccountDetailsCommon clickOk() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new AccountDetailsCommon(tool, test, user);
    }
}

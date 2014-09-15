package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ChangePasswordCommon extends CommonMenu {

    public ChangePasswordCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Change Password";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setYourPassword(String password) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("oldPassword", password);
    }

    public void setNewPassword(String password) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("newPassword", password);
    }

    public void setConfirmNewPassword(String password) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("confirmPassword", password);
    }

    public ModifyLoginPasswordCommon clickChange() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Change']");
        return new ModifyLoginPasswordCommon(tool, test, user);
    }
}

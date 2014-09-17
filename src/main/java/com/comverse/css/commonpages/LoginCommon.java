/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class LoginCommon extends CommonMenu {

    public LoginCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Login";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setLogin(String login) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("login", login);
    }

    public void selectRole(String role) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.selectVisibleTextByID("roles", role);
    }

    public AddMemberConfirmationCommon clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue']");

        return new AddMemberConfirmationCommon(tool, test, user);
    }

    public AddMemberConfirmationCommon clickCreateLoginLater() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("ON_OK");

        return new AddMemberConfirmationCommon(tool, test, user);
    }
}

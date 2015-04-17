package com.company.mercurytours.pages;

import com.framework.app.common.Common;
import com.framework.common.AutomationTool;
import com.framework.common.TestDetails;
import com.framework.common.User;

/**
 *
 * @author Ian Phillips
 */
public class SignOnMercuryTours extends MercuryToursMenu {

    public SignOnMercuryTours(AutomationTool tool, TestDetails test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Sign-on: Mercury Tours";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void enterUserName(String login) throws Exception {
        test.writeInLogFile(Common.getMethodName() + login);
        tool.enterStringUsingName("userName", login);
    }

    public void enterPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName() + password);
        tool.enterStringUsingName("password", password);
    }

    public FindAFlightMercuryTours clickSubmit() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("login");
        return new FindAFlightMercuryTours(tool, test, user);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class AddEmployeeRegisterLogin extends CommonMenu {

    public AddEmployeeRegisterLogin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Employee - Register Login";

        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void enterLogin(String login) throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.enterStringUsingId("login", login);
    }

    public AddEmployeeConfirmation clickSubmit() throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.clickUsingCssSelector("input.submit");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddEmployeeConfirmation(tool, test, user);
    }

    public RegisterLogin clickOk() throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RegisterLogin(tool, test, user);
    }
}

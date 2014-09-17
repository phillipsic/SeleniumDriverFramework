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

public class AddEmployeeContactInformation extends CommonMenu {

    public AddEmployeeContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Employee - Contact Information";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setFirstName(String firstName) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("first_name", firstName);
    }

    public void setLastName(String lastName) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("last_name", lastName);
    }

    /*
     * public AddEmployeeRegisterLogin clickSubmit() throws Exception {
     * test.writeInLog(Common.getMethodName());
     * 
     * tool.clickUsingCssSelector("input.submit"); return new
     * AddEmployeeRegisterLogin(tool, test, user); }
     */
    public void selectState(String homeState) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("home_state", homeState);
    }

    public AddEmployeeRegisterLogin clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");
        return new AddEmployeeRegisterLogin(tool, test, user);
    }
}

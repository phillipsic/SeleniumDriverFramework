/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class AddEmployeeRegisterLogin extends CommonMenu {

    public AddEmployeeRegisterLogin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Add Employee - Register Login";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterLogin(String login) throws Exception {

        
        tool.enterStringUsingId(tool, "login", login);
    }

    public AddEmployeeConfirmation clickSubmit() throws Exception {

        tool.clickUsingCssSelector(tool, "input.submit");
        return new AddEmployeeConfirmation(tool, test, user);
    }

    public RegisterLogin clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new RegisterLogin(tool, test, user);
    }
}

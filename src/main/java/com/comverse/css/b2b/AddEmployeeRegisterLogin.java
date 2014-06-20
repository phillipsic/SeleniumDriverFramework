/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddEmployeeRegisterLogin extends B2BMenu {

    public AddEmployeeRegisterLogin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Employee - Register Login";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterLogin(String login) throws Exception {

        tool.enterStringUsingId("login", login);
    }

    public AddEmployeeConfirmation clickSubmit() throws Exception {

        tool.clickUsingCssSelector("input.submit");
        return new AddEmployeeConfirmation(tool, test, user);
    }
}

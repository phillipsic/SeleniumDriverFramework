/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddEmployeeConfirmation extends B2BMenu {

    public AddEmployeeConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Employee - Confirmation";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public RegisterLogin clickSubmit() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingCssSelector("input.submit");
        return new RegisterLogin(tool, test, user);
    }
}

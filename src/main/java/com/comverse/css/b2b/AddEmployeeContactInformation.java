/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddEmployeeContactInformation extends B2BMenu {

    public AddEmployeeContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Employee - Contact Information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void enterFirstName(String firstName) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("first_name", firstName);
    }

    public void enterLastName(String lastName) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("last_name", lastName);
    }

    public AddEmployeeRegisterLogin clickSubmit() throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.clickUsingCssSelector("input.submit");
        return new AddEmployeeRegisterLogin(tool, test, user);
    }

    public void selectState(String homeState) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("home_state", homeState);

    }

    public void selectCountry(String country) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("home_country", country);
    }
}

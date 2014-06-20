/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class AddEmployeeContactInformation extends CommonMenu {

    public AddEmployeeContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Employee - Contact Information";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setFirstName(String firstName) throws Exception {

        
        tool.enterStringUsingId("first_name", firstName);
    }

    public void setLastName(String lastName) throws Exception {

        
        tool.enterStringUsingId("last_name", lastName);
    }

    public AddEmployeeRegisterLogin clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue']");

        return new AddEmployeeRegisterLogin(tool, test, user);
    }

    public void enterHomeState(String homeState) throws Exception {

        tool.selectVisibleTextByID("home_state", homeState);

    }
}

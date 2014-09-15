/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class AddEmployeeRegisterLogin extends CommonMenu {

    public AddEmployeeRegisterLogin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Employee - Register Login";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setLogin(String login) throws Exception {

        
        tool.enterStringUsingId("login", login);
    }

    public void selectRoleTelcoRetailerAdministrator() throws Exception {

        tool.clickUsingID("roles_L3:111");
    }

    public void selectRoleTelcoRetailerSubscriber() throws Exception {

        tool.clickUsingID("roles_L3:113");
    }

    public AddEmployeeConfirmation clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue']");

        return new AddEmployeeConfirmation(tool, test, user);
    }

    public AddEmployeeConfirmation clickCreateLoginLater() throws Exception {

        tool.clickUsingID("ON_OK");

        return new AddEmployeeConfirmation(tool, test, user);
    }
}

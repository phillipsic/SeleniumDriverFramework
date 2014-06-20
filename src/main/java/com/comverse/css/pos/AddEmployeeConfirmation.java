/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class AddEmployeeConfirmation extends CommonMenu {

    public AddEmployeeConfirmation(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Employee - Confirmation";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RegisterLogin clickOk() throws Exception {

        tool.clickUsingXPath("//input[@value='OK']");

        return new RegisterLogin(tool, test, user);
    }

    public RegisterLogin clickOkForRegisterLater() throws Exception {

        tool.clickUsingXPath("//input[@value='OK']");

        return new RegisterLogin(tool, test, user);
    }
}

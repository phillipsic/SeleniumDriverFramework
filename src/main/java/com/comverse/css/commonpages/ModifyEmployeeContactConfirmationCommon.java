/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyEmployeeContactConfirmationCommon extends CommonMenu {

    public ModifyEmployeeContactConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Confirm Contact Information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ModifyEmpContactConfCommon clickOk() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new ModifyEmpContactConfCommon(tool, test, user);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class UnlockDoneCommon extends CommonMenu {

    public UnlockDoneCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Unlock done";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ModifyLoginPasswordCommon clickChangePassword() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Change Password']");
        return new ModifyLoginPasswordCommon(tool, test, user);
    }

}

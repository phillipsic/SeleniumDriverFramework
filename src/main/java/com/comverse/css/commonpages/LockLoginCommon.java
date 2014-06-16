/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class LockLoginCommon extends CommonMenu {

    public LockLoginCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Lock Login";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickConfirm() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Confirm']");
    }

    public UnlockLoginCommon clickConfirmUnlock() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Confirm']");
        return new UnlockLoginCommon(tool, test, user);
    }

    public LoginInformationCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new LoginInformationCommon(tool, test, user);
    }
}

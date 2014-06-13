/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class LoginInformation extends B2CMenu {

    public LoginInformation(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Login Information";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public LockLogin clickLockLogin() throws Exception {

        tool.clickUsingLinkText(tool, "Lock Login");
        Common.sleepForNumberOfSeconds(1);
        return new LockLogin(tool, test, user);
    }

}

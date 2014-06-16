/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyLoginPasswordCommon extends CommonMenu {

    public ModifyLoginPasswordCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Modify Login Password";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public UnlockLoginCommon clickOk() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new UnlockLoginCommon(tool, test, user);
    }

    public String getNewPassword() throws Exception {

        String password = tool.getTextUsingXPath(tool, "//div[@id='mainContents']/div/div[2]/div/div/span");

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfirmNewSecretAnswerCommon extends CommonMenu {

    public ConfirmNewSecretAnswerCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Confirm new secret question and answer";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfirmChangeCommon clickOK() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new ConfirmChangeCommon(tool, test, user);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ChangeRolesCommon extends CommonMenu {

    public ChangeRolesCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Change Roles";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void clickRadioButtonOCMUser() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='L2:30']");

    }

    public void clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

    }

    public String getConfirmationMessage() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getTextUsingCssSelector("span");
    }

    public void clickRadioButtonRetailerSubscriber() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("(//input[@name='roles'])[2]");

    }

}

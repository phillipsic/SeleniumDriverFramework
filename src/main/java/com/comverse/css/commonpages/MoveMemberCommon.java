/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class MoveMemberCommon extends CommonMenu {

    public MoveMemberCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Move Member";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public MoveMemberCommon clickSelectByLevelName(String levelName) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//tr[td[contains(text(),'" + levelName + "')]]/td//a[contains(text(), 'Select')]");
        return new MoveMemberCommon(tool, test, user);
    }

    public MoveMemberCommon findSelectByLevelName(String levelName) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        if (tool.searchListUsingXPath("//tr[td[contains(text(),'" + levelName + "')]]/td//a[contains(text(), 'Select')]").size() > 0) {
            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");
        } else {
            System.out.println("Value of Unique code is MK");
            return new MoveMemberCommon(tool, test, user);
        }
    }

    public ContactInformationCommon clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        return new ContactInformationCommon(tool, test, user);
    }
}

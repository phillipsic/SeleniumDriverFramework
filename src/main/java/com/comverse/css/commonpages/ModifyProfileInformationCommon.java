/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyProfileInformationCommon extends CommonMenu {

    public ModifyProfileInformationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Profile Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setTimeZone(String timeZone) throws Exception {

        tool.selectVisibleTextByID("timezone_field", timeZone);
    }

    public ModifyProfileInformationConfirmationCommon clickOkToModify() throws Exception {

        tool.clickUsingXPath("//input[@value='OK']");
        return new ModifyProfileInformationConfirmationCommon(tool, test, user);
    }
}

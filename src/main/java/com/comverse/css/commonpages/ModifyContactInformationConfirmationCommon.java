/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyContactInformationConfirmationCommon extends CommonMenu {

    public ModifyContactInformationConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Modify Contact Information - Confirmation";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RequestSubmissionCommon clickOk() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new RequestSubmissionCommon(tool, test, user);
    }

    public RequestSubmissionCommon clickOkToConfirm() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new RequestSubmissionCommon(tool, test, user);
    }

}

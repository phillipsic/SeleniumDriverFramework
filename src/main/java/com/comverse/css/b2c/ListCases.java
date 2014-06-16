/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ListCases extends B2CMenu {

    public ListCases(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "List Cases";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddCase clickCreateCase() throws Exception {

        tool.clickUsingID(tool, "smnu_CASE_ADD");
        Common.sleepForNumberOfSeconds(1);
        return new AddCase(tool, test, user);
    }

    public ViewCase clickOnCaseIDLink(String caseID) throws Exception {

        tool.clickUsingLinkText(tool, caseID);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCase(tool, test, user);
    }

}

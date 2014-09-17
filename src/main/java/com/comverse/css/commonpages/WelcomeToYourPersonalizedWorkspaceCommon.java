/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class WelcomeToYourPersonalizedWorkspaceCommon extends CommonMenu {

    public WelcomeToYourPersonalizedWorkspaceCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Welcome to Your Personalized Workspace";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public String getHomePageWelcomeMessage() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getTextUsingXPath("/html/body/h1");
    }

    public ViewHierarchyCommon clickManageTelco() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_TELCO");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewHierarchyCommon(tool, test, user);
    }
}

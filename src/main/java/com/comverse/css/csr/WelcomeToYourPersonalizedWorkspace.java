/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.WelcomeToYourPersonalizedWorkspaceCommon;

public class WelcomeToYourPersonalizedWorkspace extends WelcomeToYourPersonalizedWorkspaceCommon {

    public WelcomeToYourPersonalizedWorkspace(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Welcome to Your Personalized Workspace";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public ViewHierarchy clickManageTelco() throws Exception {
        super.clickManageTelco();
        return new ViewHierarchy(tool, test, user);
    }
}

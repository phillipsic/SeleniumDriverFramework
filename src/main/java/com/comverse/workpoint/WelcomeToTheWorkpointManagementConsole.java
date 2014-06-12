package com.comverse.workpoint;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class WelcomeToTheWorkpointManagementConsole extends WPMCMenu {

    public WelcomeToTheWorkpointManagementConsole(AutomationTool tool, Test test, User user) {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Welcome to the Workpoint Management Console";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

}

package com.comverse.workpoint;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class WorkpointManagementConsole extends WPMCMenu {

    public WorkpointManagementConsole(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Workpoint Management Console";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getStatusOfMonitorQueue(String queueName) throws Exception {
        return tool.getTextUsingXPath(tool, "//a[contains( text(),'" + queueName + "')]/../../../../../../../../td[2]/font");

    }

}

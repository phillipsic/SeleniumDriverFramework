package com.comverse.workpoint;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class WorkpointManagementConsole extends WPMCMenu {

    public WorkpointManagementConsole(AutomationTool tool, Test test, User user) {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Workpoint Management Console";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getStatusOfMonitorQueue(String queueName) {
        return tool.driver.findElement(By.xpath("//a[contains( text(),'" + queueName + "')]/../../../../../../../../td[2]/font")).getText();

    }

}

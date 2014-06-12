package com.comverse.workpoint;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.workpoint.common.WPMCTest;

public class WPMCMenu extends WPMCTest {

    public WPMCMenu(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }

    public void clickLogOff() {
        tool.driver.findElement(By.linkText("//a/img[@title='Log Off']")).click();

    }

    public WorkpointManagementConsole clickManageMonitors() {
        tool.driver.findElement(By.xpath("//a/img[@title='Manage Monitors']")).click();
        return new WorkpointManagementConsole(tool, test, user);
    }
}

package com.comverse.workpoint;

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

    public void clickLogOff() throws Exception {
        tool.clickUsingLinkText("//a/img[@title='Log Off']");

    }

    public WorkpointManagementConsole clickManageMonitors() throws Exception {
        tool.clickUsingXPath("//a/img[@title='Manage Monitors']");
        return new WorkpointManagementConsole(tool, test, user);
    }
}

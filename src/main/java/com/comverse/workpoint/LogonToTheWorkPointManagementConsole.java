package com.comverse.workpoint;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.PropertyHelper;

public class LogonToTheWorkPointManagementConsole extends WPMCMenu {

    public LogonToTheWorkPointManagementConsole(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Logon to the WorkPoint Management Console";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setUserName(String login) throws Exception {

        tool.enterStringUsingName("ResourceID", login);
    }

    public void setPassword(String password) throws Exception {

        tool.enterStringUsingName("Password", password);
    }

    public void clickLogin() throws Exception {
        tool.clickUsingXPath("//input[@value='Submit']");
    }

    public WelcomeToTheWorkpointManagementConsole successfulWPMCAdminLogin() throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        String login = propsHelper.getPasswordProperties("LOGIN.WPMCAdmin");
        String password = propsHelper.getPasswordProperties("PASSWD.WPMCAdmin");

        this.setUserName(login);
        this.setPassword(password);
        this.clickLogin();
        return new WelcomeToTheWorkpointManagementConsole(tool, test, user);
    }

}

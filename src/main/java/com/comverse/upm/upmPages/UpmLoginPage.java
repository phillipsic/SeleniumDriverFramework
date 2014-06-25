package com.comverse.upm.upmPages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.upm.common.CommonMenu;

public class UpmLoginPage extends CommonMenu {

    public UpmLoginPage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Comverse ONE Unified Platform| Please Sign-In";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterUserName(String login) throws Exception {
        tool.enterStringUsingId("loginForm:userName", login);
    }

    public void enterPassword(String password) throws Exception {
        tool.enterStringUsingId("loginForm:password", password);
    }

    public UpmHomePage clickSignIn() throws Exception {
        tool.clickUsingID("loginForm:loginBtn");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new UpmHomePage(tool,test,user);
    }

    public String getMessage() throws Exception {
        return tool.getTextUsingXPath("//span");
    }

    public UpmHomePage successfulsecAdminLogin() throws Exception {
        
        this.enterUserName(user.getLogin());
        this.enterPassword(user.getPassword());
        this.clickSignIn();
        return new UpmHomePage(tool,test,user);
    }

}

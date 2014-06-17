package com.comverse.upm.upmPages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.sfa.sfaHomePage;

public class UpmLoginPage extends Main {

    public UpmLoginPage(AutomationTool tool) throws Exception {
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Comverse ONE Unified Platform";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setUserId(String login) throws Exception {

        tool.enterStringUsingId(tool, "userName", login);
    }

    public void setPassword(String password) throws Exception {

        tool.enterStringUsingId(tool, "password", password);
    }

    public sfaHomePage clickSignIn() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='SIGN IN']");
        return new sfaHomePage(tool, test, user);
    }

    public String getMessage() throws Exception {

        return tool.getTextUsingXPath(tool, "//span");
    }

}
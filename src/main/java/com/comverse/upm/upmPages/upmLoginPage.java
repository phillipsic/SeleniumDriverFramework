package com.comverse.upm.upmPages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.sfa.sfaHomePage;

public class upmLoginPage extends Main {

    public upmLoginPage(AutomationTool tool) {
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Comverse ONE Unified Platform";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setUserId(String login) throws Exception {

        
        tool.enterStringUsingId(tool, "Iujgbo2", login);
    }

    public void setPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "I604i25", password);
    }

    public sfaHomePage clickSignIn() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='SIGN IN']");
        return new sfaHomePage(tool, test, user);
    }

    public String getMessage() throws Exception {

        return tool.getTextUsingXPath(tool, "//span");
    }

}

package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddLoginCommon extends CommonMenu {
    static String expectedScreen = "Add Login";

    public AddLoginCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public PersonManagementCommon clickContinue() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        return new PersonManagementCommon(tool, test, user);
    }

    public void setLogin(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "login", value);
    }

    public void setPassword(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "password", value);
    }

    public void setConfirmPassword(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "confirmPassword", value);
    }
}

package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddLoginCommon extends CommonMenu {
    static String expectedScreen = "Add Login";

    public AddLoginCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public PersonManagementCommon clickContinue() throws Exception {
        tool.clickUsingXPath("//input[@value='Continue']");
        return new PersonManagementCommon(tool, test, user);
    }

    public void setLogin(String value) throws Exception {
        
        tool.enterStringUsingId("login", value);
    }

    public void setPassword(String value) throws Exception {
        
        tool.enterStringUsingId("password", value);
    }

    public void setConfirmPassword(String value) throws Exception {
        
        tool.enterStringUsingId("confirmPassword", value);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.sfa;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.common.User;

public class sfaLoginPage extends Main {

    public sfaLoginPage(AutomationTool tool, Test test, User user) throws Exception {

        this.tool = tool;
        this.test = test;
        this.user = user;
        String currentScreen = tool.getTitle();
        String expectedScreen = "Comverse ONE Billing and Active Customer Management";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setUserId(String login) throws Exception {

        tool.enterStringUsingId("Iujgbo2", login);
    }

    public void setPassword(String password) throws Exception {

        tool.enterStringUsingId("I604i25", password);
    }

    public sfaHomePage clickSignIn() throws Exception {
        tool.clickUsingXPath("//input[@value='SIGN IN']");
        return new sfaHomePage(tool, test, user);
    }

    public String getMessage() throws Exception {
        return tool.getTextUsingXPath("//span");
    }

}

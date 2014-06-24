package com.comverse.upm.upmPages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.User;

public class UpmLoginPage extends Main {

    public UpmLoginPage(AutomationTool tool) throws Exception {
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
        return new UpmHomePage(tool);
    }

    public String getMessage() throws Exception {

        return tool.getTextUsingXPath("//span");
    }

    public UpmHomePage successfulsecAdminLogin(User user) throws Exception {
        System.out.println("Login is " + user.getLogin());
        this.enterUserName(user.getLogin());
        this.enterPassword(user.getPassword());
        this.clickSignIn();
        return new UpmHomePage(tool);
    }

}

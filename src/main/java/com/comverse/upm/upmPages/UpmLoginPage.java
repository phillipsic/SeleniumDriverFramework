package com.comverse.upm.upmPages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.css.common.PropertyHelper;
import com.comverse.upm.upmPages.UpmHomePage;

public class UpmLoginPage extends Main {

    public UpmLoginPage(AutomationTool tool) throws Exception {
        String currentScreen = tool.getTitle();
        String expectedScreen = "Comverse ONE Unified Platform| Please Sign-In";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setUserName(String login) throws Exception {

        tool.enterStringUsingId("loginForm:userName", login);
    }

    public void setPassword(String password) throws Exception {

        tool.enterStringUsingId("loginForm:password", password);
    }

    public UpmHomePage clickSignIn() throws Exception {
        tool.clickUsingID("loginForm:loginBtn");
        return new UpmHomePage(tool);
    }

    public String getMessage() throws Exception {

        return tool.getTextUsingXPath("//span");
    }

    public UpmHomePage successfulsecAdminLogin() throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        String login = propsHelper.getPasswordProperties("LOGIN.SECAdmin");
        String password = propsHelper.getPasswordProperties("PASSWD.SECAdmin");

        System.out.println("Login is " + login);
        this.setUserName(login);
        this.setPassword(password);
        this.clickSignIn();
        return new UpmHomePage(tool);
    }

}

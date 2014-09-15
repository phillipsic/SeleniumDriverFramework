package com.comverse.css.otg;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.MyshapeCommon;

public class OTGHome extends MyshapeCommon {

    public OTGHome(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "login";
        for (String currentScreenSplitted : currentScreen.split("/")) {
            currentScreen = currentScreenSplitted;
        }
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public AccountDashboard loginToOTGAsCOP() throws Exception {
        successfulLogin(user);
        Thread.sleep(2000);
        System.out.println("Logged in as COP");
        return new AccountDashboard(tool, test, user);
    }

    public SubscriberDashboard loginToOTGAsCUP(String SubscriberID) throws Exception {
        successfulLogin(user);
        Thread.sleep(2000);
        System.out.println("Logged in as CUP");
        return new SubscriberDashboard(tool, test, user, SubscriberID);
    }

    @Override
    public void setUserName(String login) throws Exception {
        tool.enterStringUsingId("username", login);
    }

    @Override
    public void clickLogin() throws Exception {
        tool.clickUsingID("login");
    }

    public void clickHomeBtn() throws Exception {
        tool.clickUsingCssSelector("div.btn-group.btn-group-justified > div.btn-group > button.btn.btn-default");
        System.out.println("Click Home");
        Thread.sleep(1000);
    }

    @Override
    public OTGHome clickLogout() throws Exception {
        tool.clickUsingCssSelector("button.btn.btn-default");
        Thread.sleep(1000);
        System.out.println("Logged out");
        return new OTGHome(tool, test, user);
    }
}

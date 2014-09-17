package com.comverse.sec;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.csr.RestorePreviousBasket;
import com.comverse.css.csr.WorkSpace;

public class ComverseOneSingleSignOn extends Main {

    public ComverseOneSingleSignOn(AutomationTool tool, Test test, User user) throws Exception {
        this.test = test;
        this.user = user;
        this.tool = tool;
        String currentScreen = tool.getTitle();
        String expectedScreen = "Comverse – Single Signon";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setUserName(AutomationTool tool, User user) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + user.getLogin() + ")");
        tool.enterStringUsingId("username", user.getLogin());
    }

    public void setPassword(AutomationTool tool, User user) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + user.getPassword() + ")");
        tool.enterStringUsingId("password", user.getPassword());
    }

    public void setRealm(AutomationTool tool, User user) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + user.getRealm() + ")");
        tool.selectVisibleTextByID("realmselect", user.getRealm());
    }

    public void clickLogin(AutomationTool tool) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("submit");
    }

    public WorkSpace loginToCSRAsCSRAdmin() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        loginSSOUser();
        Common.checkForExistingBasketAndDiscard(tool);
        return new WorkSpace(tool, test, user);
    }

    public RestorePreviousBasket loginToCSRAsCSRAdminWithPreviousBasket() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        loginSSOUser();
        return new RestorePreviousBasket(tool, test, user);
    }

    public void loginSSOUser() throws Exception {
        test.writeInLogFile("INFO", "Login: " + user.getLogin() + ", Password: " + user.getPassword());
        this.setUserName(tool, user);
        this.setPassword(tool, user);
        this.setRealm(tool, user);
        this.clickLogin(tool);
    }

}

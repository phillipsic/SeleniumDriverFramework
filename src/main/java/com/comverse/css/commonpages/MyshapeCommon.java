package com.comverse.css.commonpages;

import java.util.MissingResourceException;

import com.comverse.common.Application;
import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class MyshapeCommon extends CommonMenu {

    public MyshapeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    public void successfulLogin(User user) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        if (user.getLogin() == null || user.getLogin().length() == 0) {
            throw new MissingResourceException("Missing property Login " + user.getLogin(), PASSWORD_PROPERTY_FILE, user.getLogin());
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            throw new MissingResourceException("Missing property Password " + user.getPassword(), PASSWORD_PROPERTY_FILE, user.getPassword());
        }

        this.setUserName(user.getLogin());
        this.setPassword(user.getPassword());
        if (user.getRealm() != null) {
            this.selectRealm(user.getRealm());
        }
        this.clickLogin();

        if (tool.getPageSource().contains("Please enter a valid user name and password.")) {
            throw new Exception("Invalid username or password - IS USER CREATED? ");
        }

        if (tool.getPageSource().contains("Synchronization Failed")) {
            throw new Exception("Synchronization Failed - ENVIRONMENT PROBLEM?");
        }

    }

    public void setYourPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("password_old", password);
    }

    public void setNewPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("password_new", password);
    }

    public void setConfirmNewPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("password_verify", password);
    }

    public void setSecretAnswer(String secretAnswer) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("secretAnswer", secretAnswer);
    }

    public void clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
    }

    public void clickSubmit() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Submit']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void clickHomePage() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Home Page']");
    }

    public void clickAdminLogin(Application application) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.get(application.appURL() + "/jfn?entry=admin_login");
    }

    public void clickForgotYourPassword() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("lnk_FORGOTTEN_PASSWORD");
    }

    public void setUserName(String login) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + login + ")");
        tool.enterStringUsingId("login", login);
    }

    public void setPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + password + ")");
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("password", password);
    }

    public void selectRealm(String realm) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " with data (" + realm + ")");
        if (tool.getPageSource().contains("Domain")) {
            tool.selectVisibleTextByID("realm", realm);
        }
    }

    public void clickLogin() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("LoginButton");
    }

    public String getMessage() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getTextUsingXPath("//span");
    }

    public MyshapeCommon unsuccessfulLogin(User user) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        this.setUserName(user.getLogin());
        this.setPassword(user.getPassword());
        this.clickLogin();

        return new MyshapeCommon(tool, test, user);
    }

    public String getTempPasswordFromPage() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String password = tool.getTextUsingXPath("//span");
        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());

        return password.trim();
    }

    public WorkSpaceCommon clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue']");

        return new WorkSpaceCommon(tool, test, user);
    }

    public String getChangePasswordOnFirstLoginMessage() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        System.out.println(">>" + tool.getTextUsingCssSelector("span"));

        return tool.getTextUsingCssSelector("span");
    }
}

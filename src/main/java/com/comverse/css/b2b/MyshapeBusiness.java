/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.MyshapeCommon;

public class MyshapeBusiness extends MyshapeCommon {

    public MyshapeBusiness(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Myshape Business";

        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void login(User user) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("login", user.getLogin());

        tool.enterStringUsingId("password", user.getPassword());
        tool.clickUsingName("LoginButton");

        if (tool.getPageSource().contains("Please enter a valid user name and password.")) {
            throw new Exception("Invalid username or password - IS USER CREATED? ");
        }

        if (tool.getPageSource().contains("Synchronization Failed")) {
            throw new Exception("Synchronization Failed - ENVIRONMENT PROBLEM?");
        }

    }

    public WorkSpace loginToB2B(User user) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        login(user);
        Common.checkForExistingBasketAndDiscard(tool);
        return new WorkSpace(tool, test, user);
    }

    public RestorePreviousBasket loginToB2BWithPreviousBasket() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        login(user);
        return new RestorePreviousBasket(tool, test, user);
    }

    public void loginWithChangeOfPassword(String loginname, String password) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        this.enterLoginName(loginname);
        this.enterPassword(password);
        this.clickLoginButtonForFirstTime();
    }

    public void enterLoginName(String loginName) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("login", loginName);
    }

    public void enterNewPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("password_new", password);
    }

    public void enterNewPasswordVerify(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("password_verify", password);
    }

    public void enterOldPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("password_old", password);
    }

    public void enterPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("password", password);
    }

    public void enterSecretAnswer(String secretAnswer) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("secretAnswer", secretAnswer);
    }

    public WorkSpace clickLoginButton() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("LoginButton");
        return new WorkSpace(tool, test, user);
    }

    public WorkSpace clickChangeButton() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingCssSelector("input.submit");
        return new WorkSpace(tool, test, user);
    }

    public void clickLoginButtonForFirstTime() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("LoginButton");
    }

    @Override
    public ContactInformation clickUserInformation() throws Exception {
        super.clickUserInformation();
        return new ContactInformation(tool, test, user);
    }
}

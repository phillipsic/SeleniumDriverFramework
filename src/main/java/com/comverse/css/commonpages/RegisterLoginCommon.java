/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RegisterLoginCommon extends CommonMenu {

    public RegisterLoginCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle().toLowerCase();
        String expectedScreen = "Register login".toLowerCase();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setLogin(String login) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("login", login);
    }

    public void selectRole(String role) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("roles", role);
    }

    public AddMemberConfirmationCommon clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");

        return new AddMemberConfirmationCommon(tool, test, user);
    }

    public RegisterLoginCommon clickRegisterLoginContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");

        return new RegisterLoginCommon(tool, test, user);
    }

    public void clickRadioButtonTelcoCSRUser() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("(//input[@name='roles'])[9]");

    }

    public void clickRadioButtonOCMUser() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@name='roles']");

    }

    public String getTempPasswordFromPage() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        String password = tool.getTextUsingXPath("//*[@id=\"mainContents\"]/div/div[2]/div/div/span");

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();

    }

    public ViewHierarchyCommon clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

        return new ViewHierarchyCommon(tool, test, user);
    }

}

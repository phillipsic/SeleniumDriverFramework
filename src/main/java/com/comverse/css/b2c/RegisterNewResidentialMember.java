/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RegisterNewResidentialMember extends B2CMenu {

    public RegisterNewResidentialMember(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Register New Residential Member";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void enterFirstName(String firstName) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + firstName + ")");

        tool.enterStringUsingId("firstname", firstName);
        System.out.println("Login - " + firstName);

    }

    public void enterLastName(String lastName) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + lastName + ")");

        tool.enterStringUsingId("lastname", lastName);
        System.out.println("Password - " + lastName);

    }

    public void enterLogin(String login) throws Exception {

        test.writeInLog(Common.getMethodName() + " using data (" + login + ")");
        tool.enterStringUsingId("login", login);
        System.out.println("Login - " + login);

    }

    public void enterPassword(String password) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + password + ")");

        tool.enterStringUsingId("password", password);
        System.out.println("Password - " + password);

    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {

        test.writeInLog(Common.getMethodName() + " using data (" + confirmPassword + ")");
        tool.enterStringUsingId("confirmPassword", confirmPassword);

    }

    public void clickSubmit() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Submit']");
    }

    public RequestSubmission clickConfirm() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Confirm']");
        return new RequestSubmission(tool, test, user);
    }

    public void clickResidentialSubscriber() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("(//input[@name='role'])[2]");
    }

    public RequestSubmission createResidentialSubscriber(String uniqueString, String password) throws Exception {

        this.enterFirstName("FN" + uniqueString);
        this.enterLastName("LN" + uniqueString);
        this.enterLogin(uniqueString);
        this.enterPassword(password);
        this.enterConfirmPassword(password);
        this.clickResidentialSubscriber();
        this.clickSubmit();
        this.clickConfirm();
        return new RequestSubmission(tool, test, user);
    }
}

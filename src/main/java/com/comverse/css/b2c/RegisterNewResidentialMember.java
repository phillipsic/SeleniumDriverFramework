/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RegisterNewResidentialMember extends B2CMenu {

    public RegisterNewResidentialMember(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Register New Residential Member";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public void enterFirstName(String firstName) throws Exception {

        
        tool.enterStringUsingId("firstname", firstName);
        System.out.println("Login - " + firstName);

    }

    public void enterLastName(String lastName) throws Exception {

        
        tool.enterStringUsingId("lastname", lastName);
        System.out.println("Password - " + lastName);

    }

    public void enterLogin(String login) throws Exception {

        
        tool.enterStringUsingId("login", login);
        System.out.println("Login - " + login);

    }

    public void enterPassword(String password) throws Exception {

        
        tool.enterStringUsingId("password", password);
        System.out.println("Password - " + password);

    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {

        
        tool.enterStringUsingId("confirmPassword", confirmPassword);

    }

    public void clickSubmit() throws Exception {

        tool.clickUsingXPath("//input[@value='Submit']");
    }

    public RequestSubmission clickConfirm() throws Exception {

        tool.clickUsingXPath("//input[@value='Confirm']");
        return new RequestSubmission(tool, test, user);
    }

    public void clickResidentialSubscriber() throws Exception {

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

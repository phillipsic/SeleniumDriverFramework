/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.MyshapeCommon;

public class MyshapeBusiness extends MyshapeCommon {

    public MyshapeBusiness(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Myshape Business";

        if (!expectedScreen.equals(tool.driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void login(User user) throws Exception {
        
        tool.enterStringUsingId(tool, "login", user.getLogin());
        
        tool.enterStringUsingId(tool, "password", user.getPassword());
        tool.driver.findElement(By.name("LoginButton")).click();

        if (tool.driver.getPageSource().contains("Please enter a valid user name and password.")) {
            throw new Exception("Invalid username or password - IS USER CREATED? ");
        }

        if (tool.driver.getPageSource().contains("Synchronization Failed")) {
            throw new Exception("Synchronization Failed - ENVIRONMENT PROBLEM?");
        }

    }

    public WorkSpace loginToB2B(User user) throws Exception {
        login(user);
        Common.checkForExistingBasketAndDiscard(tool);
        return new WorkSpace(tool, test, user);
    }

    public RestorePreviousBasket loginToB2BWithPreviousBasket() throws Exception {
        login(user);
        return new RestorePreviousBasket(tool, test, user);
    }

    public void loginWithChangeOfPassword(String loginname, String password) throws Exception {
        this.enterLoginName(loginname);
        this.enterPassword(password);
        this.clickLoginButtonForFirstTime();
    }

    public void enterLoginName(String loginName) throws Exception {
        
        tool.enterStringUsingId(tool, "login", loginName);
    }

    public void enterNewPassword(String password) throws Exception {
        
        tool.enterStringUsingId(tool, "password_new", password);
    }

    public void enterNewPasswordVerify(String password) throws Exception {
        
        tool.enterStringUsingId(tool, "password_verify", password);
    }

    public void enterOldPassword(String password) throws Exception {
        
        tool.enterStringUsingId(tool, "password_old", password);
    }

    public void enterPassword(String password) throws Exception {
        
        tool.enterStringUsingId(tool, "password", password);
    }

    public void enterSecretAnswer(String secretAnswer) throws Exception {
        
        tool.enterStringUsingId(tool, "secretAnswer", secretAnswer);
    }

    public WorkSpace clickLoginButton() throws Exception {
        tool.driver.findElement(By.name("LoginButton")).click();
        return new WorkSpace(tool, test, user);
    }

    public WorkSpace clickChangeButton() throws Exception {
        tool.driver.findElement(By.cssSelector("input.submit")).click();
        return new WorkSpace(tool, test, user);
    }

    public void clickLoginButtonForFirstTime() throws Exception {
        tool.driver.findElement(By.name("LoginButton")).click();
    }

    @Override
    public ContactInformation clickUserInformation() throws Exception {
        super.clickUserInformation();
        return new ContactInformation(tool, test, user);
    }
}

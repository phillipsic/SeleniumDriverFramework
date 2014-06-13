/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class LoginCommon extends CommonMenu {

    public LoginCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Login";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setLogin(String login) throws Exception {
        
        tool.enterStringUsingId(tool, "login", login);
    }

    public void selectRole(String role) throws Exception {
        new Select(tool.searchUsingID(tool, "roles")).selectByVisibleText(role);
    }

    public AddMemberConfirmationCommon clickContinue() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Continue']");

        return new AddMemberConfirmationCommon(tool, test, user);
    }

    public AddMemberConfirmationCommon clickCreateLoginLater() throws Exception {
        tool.driver.findElement(By.id("ON_OK")).click();

        return new AddMemberConfirmationCommon(tool, test, user);
    }
}

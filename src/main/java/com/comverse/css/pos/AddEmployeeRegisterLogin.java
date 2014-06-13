/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class AddEmployeeRegisterLogin extends CommonMenu {

    public AddEmployeeRegisterLogin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Add Employee - Register Login";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setLogin(String login) throws Exception {

        
        tool.enterStringUsingId(tool, "login", login);
    }

    public void selectRoleTelcoRetailerAdministrator() throws Exception {

        tool.driver.findElement(By.id("roles_L3:111")).click();
    }

    public void selectRoleTelcoRetailerSubscriber() throws Exception {

        tool.driver.findElement(By.id("roles_L3:113")).click();
    }

    public AddEmployeeConfirmation clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();

        return new AddEmployeeConfirmation(tool, test, user);
    }

    public AddEmployeeConfirmation clickCreateLoginLater() throws Exception {

        tool.driver.findElement(By.id("ON_OK")).click();

        return new AddEmployeeConfirmation(tool, test, user);
    }
}

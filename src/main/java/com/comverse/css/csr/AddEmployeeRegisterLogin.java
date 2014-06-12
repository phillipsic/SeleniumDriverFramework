/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

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

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterLogin(String login) throws Exception {

        tool.driver.findElement(By.id("login")).clear();
        tool.driver.findElement(By.id("login")).sendKeys(login);
    }

    public AddEmployeeConfirmation clickSubmit() throws Exception {

        tool.driver.findElement(By.cssSelector("input.submit")).click();
        return new AddEmployeeConfirmation(tool, test, user);
    }

    public RegisterLogin clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new RegisterLogin(tool, test, user);
    }
}

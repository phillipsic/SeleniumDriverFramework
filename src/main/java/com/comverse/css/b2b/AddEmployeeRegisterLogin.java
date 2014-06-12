/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddEmployeeRegisterLogin extends B2BMenu {

    public AddEmployeeRegisterLogin(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Add Employee - Register Login";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
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
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class AddEmployeeContactInformation extends CommonMenu {

    public AddEmployeeContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Add Employee - Contact Information";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setFirstName(String firstName) throws Exception {

        tool.driver.findElement(By.id("first_name")).clear();
        tool.driver.findElement(By.id("first_name")).sendKeys(firstName);
    }

    public void setLastName(String lastName) throws Exception {

        tool.driver.findElement(By.id("last_name")).clear();
        tool.driver.findElement(By.id("last_name")).sendKeys(lastName);
    }

    public AddEmployeeRegisterLogin clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();

        return new AddEmployeeRegisterLogin(tool, test, user);
    }

    public void enterHomeState(String homeState) throws Exception {

        new Select(tool.driver.findElement(By.id("home_state"))).selectByVisibleText(homeState);

    }
}

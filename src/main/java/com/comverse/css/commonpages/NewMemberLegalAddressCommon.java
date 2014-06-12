/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class NewMemberLegalAddressCommon extends CommonMenu {

    public NewMemberLegalAddressCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "New Member - Legal Address";

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

    public LoginCommon clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();

        return new LoginCommon(tool, test, user);
    }
}

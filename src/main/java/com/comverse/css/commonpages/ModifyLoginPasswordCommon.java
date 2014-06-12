/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyLoginPasswordCommon extends CommonMenu {

    public ModifyLoginPasswordCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Login Password";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickOk() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();

    }

    public String getNewPassword() throws Exception {

        String password = tool.driver.findElement(By.xpath("//div[@id='mainContents']/div/div[2]/div/div/span")).getText();

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();
    }
}

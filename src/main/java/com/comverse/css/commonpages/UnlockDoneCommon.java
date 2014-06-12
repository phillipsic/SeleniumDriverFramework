/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class UnlockDoneCommon extends CommonMenu {

    public UnlockDoneCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Unlock done";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ModifyLoginPasswordCommon clickChangePassword() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Change Password']")).click();
        return new ModifyLoginPasswordCommon(tool, test, user);
    }

}

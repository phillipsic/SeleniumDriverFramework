/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class UnlockLoginCommon extends CommonMenu {

    public UnlockLoginCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Unlock Login";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public UnlockDoneCommon clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new UnlockDoneCommon(tool, test, user);
    }

    public LoginInformationCommon clickOK() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new LoginInformationCommon(tool, test, user);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ChangeRolesCommon extends CommonMenu {

    public ChangeRolesCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Change Roles";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickRadioButtonOCMUser() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='L2:30']");

    }

    public void clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");

    }

    public String getConfirmationMessage() throws Exception {

        return tool.driver.findElement(By.cssSelector("span")).getText();
    }

    public void clickRadioButtonRetailerSubscriber() throws Exception {

        tool.clickUsingXPath(tool, "(//input[@name='roles'])[2]");

    }

}

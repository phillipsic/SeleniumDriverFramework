/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddLevelConfirmationCommon extends CommonMenu {
    static String expectedScreen = "Add Level - Confirmation";

    public AddLevelConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddLevelCommon clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AddLevelCommon(tool, test, user);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class LevelLegalContactCommon extends CommonMenu {

    public LevelLegalContactCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Level Legal Contact";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewHierarchyCommon clickBack() throws Exception {
        tool.driver.findElement(By.id("youcan_ON_BACK")).click();
        return new ViewHierarchyCommon(tool, test, user);
    }

    public ModifyLevelLegalContactCommon clickModifyLevelLegalContact() throws Exception {
        tool.driver.findElement(By.id("youcan_MODIFY_CONTACT")).click();
        return new ModifyLevelLegalContactCommon(tool, test, user);
    }
}

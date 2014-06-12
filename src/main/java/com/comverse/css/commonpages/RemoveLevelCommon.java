/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RemoveLevelCommon extends CommonMenu {

    public RemoveLevelCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Remove Level";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public ViewHierarchyCommon clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//form[@id='form_OK']/div/input")).click();

        return new ViewHierarchyCommon(tool, test, user);

    }

    public RemoveLevelCommon clickOkToRemoveLevel() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new RemoveLevelCommon(tool, test, user);

    }

    public ViewHierarchyCommon clickOkToConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ViewHierarchyCommon(tool, test, user);

    }

}

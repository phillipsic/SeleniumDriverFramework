/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyLevelLegalContactCommon extends CommonMenu {

    public ModifyLevelLegalContactCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Level Legal Contact";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewHierarchyCommon clickBack() throws Exception {
        tool.driver.findElement(By.id("youcan_ON_BACK")).click();
        return new ViewHierarchyCommon(tool, test, user);
    }

    public void setNewLevelName(String uniqueString) throws Exception {

        
        tool.enterStringUsingId(tool, "company_name", uniqueString);
    }

    public void setNewLevelState(String uniqueState) throws Exception {

        new Select(tool.searchUsingID(tool, "home_state")).selectByVisibleText(uniqueState);

    }

    public ModifyLevelLegalContactCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");

        return new ModifyLevelLegalContactCommon(tool, test, user);
    }

    public ModifyLevelLegalContactCommon clickOkAgain() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");

        return new ModifyLevelLegalContactCommon(tool, test, user);
    }

    public LevelLegalContactCommon clickOkButton() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");

        return new LevelLegalContactCommon(tool, test, user);
    }
}

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

public class AddSubLevelLegalAddressCommon extends CommonMenu {
    static String expectedScreen = "Add Sub Level - Legal Address";

    public AddSubLevelLegalAddressCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setLevelName(String levelName) throws Exception {

        
        tool.enterStringUsingId(tool, "company_name", levelName);
    }

    public void setLevelState(String levelState) throws Exception {

        new Select(tool.searchUsingID(tool, "home_state")).selectByVisibleText(levelState);
        /*
         * 
         * tool.enterStringUsingId(tool, "home_state", levelState);
         */
    }

    public RequestSubmissionCommon clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new RequestSubmissionCommon(tool, test, user);
    }
}

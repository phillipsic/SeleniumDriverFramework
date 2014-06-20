/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddSubLevelLegalAddressCommon extends CommonMenu {
    static String expectedScreen = "Add Sub Level - Legal Address";

    public AddSubLevelLegalAddressCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setLevelName(String levelName) throws Exception {

        
        tool.enterStringUsingId("company_name", levelName);
    }

    public void setLevelState(String levelState) throws Exception {

        tool.selectVisibleTextByID("home_state", levelState);
        /*
         * 
         * tool.enterStringUsingId("home_state", levelState);
         */
    }

    public RequestSubmissionCommon clickOk() throws Exception {

        tool.clickUsingXPath("//input[@value='OK']");

        return new RequestSubmissionCommon(tool, test, user);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class NewMemberLegalAddressCommon extends CommonMenu {

    public NewMemberLegalAddressCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "New Member - Legal Address";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setFirstName(String firstName) throws Exception {

        
        tool.enterStringUsingId(tool, "first_name", firstName);
    }

    public void setLastName(String lastName) throws Exception {

        
        tool.enterStringUsingId(tool, "last_name", lastName);
    }

    public LoginCommon clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");

        return new LoginCommon(tool, test, user);
    }
}

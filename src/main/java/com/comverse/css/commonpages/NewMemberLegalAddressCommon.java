/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class NewMemberLegalAddressCommon extends CommonMenu {

    public NewMemberLegalAddressCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "New Member - Legal Address";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setFirstName(String firstName) throws Exception {  test.writeInLog(Common.getMethodName());

        
        tool.enterStringUsingId("first_name", firstName);
    }

    public void setLastName(String lastName) throws Exception {  test.writeInLog(Common.getMethodName());

        
        tool.enterStringUsingId("last_name", lastName);
    }

    public LoginCommon clickContinue() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");

        return new LoginCommon(tool, test, user);
    }
}

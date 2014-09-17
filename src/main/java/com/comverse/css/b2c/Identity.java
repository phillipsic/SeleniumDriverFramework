/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class Identity extends B2CMenu {

    public Identity(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Identity";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public String getFirstName() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getAttributeUsingId("first_name", "value");
    }

    public String getLastName() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return tool.getAttributeUsingId("last_name", "value");
    }

    public SubscriberDetail clickCancel() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Cancel']");
        return new SubscriberDetail(tool, test, user);
    }

    public RequestSubmission clickModify() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Modify']");
        return new RequestSubmission(tool, test, user);
    }

    public void setFirstName(String firstName) throws Exception {

        test.writeInLogFile(Common.getMethodName() + " using data (" + firstName + ")");
        tool.enterStringUsingId("first_name", firstName);
    }

    public void setLastName(String lastName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + lastName + ")");

        tool.enterStringUsingId("last_name", lastName);

    }

}

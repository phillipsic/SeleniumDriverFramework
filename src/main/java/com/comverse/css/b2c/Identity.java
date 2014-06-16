/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class Identity extends B2CMenu {

    public Identity(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Identity";

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getFirstName() throws Exception {

        return tool.getAttributeUsingId(tool, "first_name", "value");
    }

    public String getLastName() throws Exception {

        return tool.getAttributeUsingId(tool, "last_name", "value");
    }

    public SubscriberDetail clickCancel() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Cancel']");
        return new SubscriberDetail(tool, test, user);
    }

    public RequestSubmission clickModify() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Modify']");
        return new RequestSubmission(tool, test, user);
    }

    public void setFirstName(String firstName) throws Exception {

        
        tool.enterStringUsingId(tool, "first_name", firstName);
    }

    public void setLastName(String lastName) throws Exception {

        
        tool.enterStringUsingId(tool, "last_name", lastName);

    }

}

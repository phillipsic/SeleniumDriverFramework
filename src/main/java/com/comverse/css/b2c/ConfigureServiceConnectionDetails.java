/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfigureServiceConnectionDetails extends B2CMenu {

    public ConfigureServiceConnectionDetails(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Configure Service Connection Details";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket clickContinue() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public void setServiceConnectionEmail(String Email) throws Exception {

        // 
        // tool.enterStringUsingId(tool, "inputFields1180", Email);

        
        tool.enterStringUsingXPath(tool, ".//span[contains(text(), 'Enter your Email address:')]/../../div[2]/input", Email);

    }
}

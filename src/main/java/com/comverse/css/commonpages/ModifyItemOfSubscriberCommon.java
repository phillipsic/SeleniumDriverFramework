/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyItemOfSubscriberCommon extends CommonMenu {

    public ModifyItemOfSubscriberCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Modify Item of Subscriber";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ModifyItemCommon clickConfirm() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Confirm']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ModifyItemCommon(tool, test, user);
    }
}

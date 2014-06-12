/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyItemOfSubscriberCommon;

public class ModifyItemOfSubscriber extends ModifyItemOfSubscriberCommon {

    public ModifyItemOfSubscriber(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Item of Subscriber";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public ModifyItem clickConfirm() throws Exception {
        super.clickConfirm();
        return new ModifyItem(tool, test, user);
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyOfferParametersCommon;

public class ModifyOfferParameters extends ModifyOfferParametersCommon {

    public ModifyOfferParameters(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Modify Offer Parameters";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
	public ModifyItemOfSubscriber clickModify() throws Exception {
        super.clickModify();
        return new ModifyItemOfSubscriber(tool, test, user);
    }

}

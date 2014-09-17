/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RemoveOfferCommon extends CommonMenu {

    public RemoveOfferCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Remove Offer";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public OfferCancellationCommon clickYes() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("(//input[@value='Yes'])");
        return new OfferCancellationCommon(tool, test, user);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyOfferParametersCommon extends CommonMenu {

    public ModifyOfferParametersCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Offer Parameters";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void checkVoiceMailEnableToNo() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//label[contains(text(),'Voice Mail Enable')]/following-sibling::input");
    }

    public void enterVoiceMailSize(String voiceMailSize) throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.enterStringUsingXPath("//label[contains(text(),'Voice Mail Size')]/../input", voiceMailSize);
    }

    public ModifyItemOfSubscriberCommon clickModify() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Modify']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ModifyItemOfSubscriberCommon(tool, test, user);
    }

    public String getVoiceMailSize() throws Exception {
        test.writeInLog(Common.getMethodName());
        return tool.getAttributeUsingXpath("//label[contains(text(),'Voice Mail Size')]/../input", "value");
    }
}

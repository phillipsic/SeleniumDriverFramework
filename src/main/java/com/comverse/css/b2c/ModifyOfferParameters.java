/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyOfferParameters extends B2CMenu {

    public ModifyOfferParameters(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Modify Offer Parameters";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void checkVoiceMailEnableToNo() throws Exception {
        tool.clickUsingXPath(tool, "//label[contains(text(),'Voice Mail Enable')]/following-sibling::input");
    }

    public void enterVoiceMailSize(String voiceMailSize) throws Exception {
        
        tool.enterStringUsingXPath(tool, "//label[contains(text(),'Voice Mail Size')]/../input", voiceMailSize);
    }

    public ModifyItemOfSubscriber clickModify() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Modify']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ModifyItemOfSubscriber(tool, test, user);
    }

    public String getVoiceMailSize() throws Exception {

        return tool.driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Size')]/../input")).getAttribute("value");
    }
}

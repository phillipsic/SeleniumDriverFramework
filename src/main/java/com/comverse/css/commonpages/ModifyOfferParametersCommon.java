/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyOfferParametersCommon extends CommonMenu {

    public ModifyOfferParametersCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Offer Parameters";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void checkVoiceMailEnableToNo() throws Exception {
        tool.driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Enable')]/following-sibling::input")).click();
    }

    public void enterVoiceMailSize(String voiceMailSize) throws Exception {
        
        tool.enterStringUsingXPath(tool, "//label[contains(text(),'Voice Mail Size')]/../input", voiceMailSize);
    }

    public ModifyItemOfSubscriberCommon clickModify() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Modify']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ModifyItemOfSubscriberCommon(tool, test, user);
    }

    public String getVoiceMailSize() throws Exception {

        return tool.driver.findElement(By.xpath("//label[contains(text(),'Voice Mail Size')]/../input")).getAttribute("value");
    }
}

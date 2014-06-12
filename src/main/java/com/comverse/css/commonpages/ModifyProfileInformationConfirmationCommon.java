/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyProfileInformationConfirmationCommon extends CommonMenu {

    public ModifyProfileInformationConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Profile Information - Confirmation";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RequestSubmissionCommon clickOkToConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new RequestSubmissionCommon(tool, test, user);
    }
}

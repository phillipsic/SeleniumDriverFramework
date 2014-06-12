/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class OutboundCommunicationTemplateCommon extends CommonMenu {

    public OutboundCommunicationTemplateCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Outbound Communication Template";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddOutboundCommunicationTemplateCommon clickAdd() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Add']")).click();

        return new AddOutboundCommunicationTemplateCommon(tool, test, user);
    }
}

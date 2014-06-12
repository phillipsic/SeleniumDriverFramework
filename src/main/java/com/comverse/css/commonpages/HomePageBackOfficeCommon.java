/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class HomePageBackOfficeCommon extends CommonMenu {

    public HomePageBackOfficeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Welcome to Your Workspace";

        if (!expectedScreen.equals(tool.driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddressAdministrationCommon clickAddressAdministration() throws Exception {

        tool.driver.findElement(By.id("smnu_ADDRESS_ADMINISTRATION")).click();

        return new AddressAdministrationCommon(tool, test, user);

    }

    public TokensfoundCommon clickTokenAdministration() throws Exception {

        tool.driver.findElement(By.id("smnu_TOKEN_ADMINISTRATION")).click();

        return new TokensfoundCommon(tool, test, user);

    }

    public OutboundCommunicationTemplateCommon clickTemplateAdministration() throws Exception {

        tool.driver.findElement(By.id("smnu_TEMPLATE_ADMINISTRATION")).click();

        return new OutboundCommunicationTemplateCommon(tool, test, user);

    }
}

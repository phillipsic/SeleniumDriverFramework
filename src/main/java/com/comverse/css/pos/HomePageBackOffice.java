/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.HomePageBackOfficeCommon;
import com.comverse.css.commonpages.TokensfoundCommon;

public class HomePageBackOffice extends HomePageBackOfficeCommon {

    public HomePageBackOffice(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Home Page - Back Office, Inventory and Order Management";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    @Override
	public AddressAdministration clickAddressAdministration() throws Exception {

        tool.driver.findElement(By.id("smnu_ADDRESS_ADMINISTRATION")).click();

        return new AddressAdministration(tool, test, user);

    }

    @Override
	public TokensfoundCommon clickTokenAdministration() throws Exception {

        tool.driver.findElement(By.id("smnu_TOKEN_ADMINISTRATION")).click();

        return new TokensfoundCommon(tool, test, user);

    }

    @Override
	public OutboundCommunicationTemplate clickTemplateAdministration() throws Exception {

        tool.driver.findElement(By.id("smnu_TEMPLATE_ADMINISTRATION")).click();

        return new OutboundCommunicationTemplate(tool, test, user);

    }
}

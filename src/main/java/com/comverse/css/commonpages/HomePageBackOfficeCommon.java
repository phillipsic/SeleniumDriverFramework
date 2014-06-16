/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class HomePageBackOfficeCommon extends CommonMenu {

    public HomePageBackOfficeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Welcome to Your Workspace";

        if (!expectedScreen.equals(tool.driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddressAdministrationCommon clickAddressAdministration() throws Exception {

        tool.clickUsingID(tool, "smnu_ADDRESS_ADMINISTRATION");

        return new AddressAdministrationCommon(tool, test, user);

    }

    public TokensfoundCommon clickTokenAdministration() throws Exception {

        tool.clickUsingID(tool, "smnu_TOKEN_ADMINISTRATION");

        return new TokensfoundCommon(tool, test, user);

    }

    public OutboundCommunicationTemplateCommon clickTemplateAdministration() throws Exception {

        tool.clickUsingID(tool, "smnu_TEMPLATE_ADMINISTRATION");

        return new OutboundCommunicationTemplateCommon(tool, test, user);

    }
}

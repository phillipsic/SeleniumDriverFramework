/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.HomePageBackOfficeCommon;
import com.comverse.css.commonpages.TokensfoundCommon;

public class HomePageBackOffice extends HomePageBackOfficeCommon {

    public HomePageBackOffice(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Home Page - Back Office, Inventory and Order Management";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    @Override
	public AddressAdministration clickAddressAdministration() throws Exception {

        tool.clickUsingID(tool, "smnu_ADDRESS_ADMINISTRATION");

        return new AddressAdministration(tool, test, user);

    }

    @Override
	public TokensfoundCommon clickTokenAdministration() throws Exception {

        tool.clickUsingID(tool, "smnu_TOKEN_ADMINISTRATION");

        return new TokensfoundCommon(tool, test, user);

    }

    @Override
	public OutboundCommunicationTemplate clickTemplateAdministration() throws Exception {

        tool.clickUsingID(tool, "smnu_TEMPLATE_ADMINISTRATION");

        return new OutboundCommunicationTemplate(tool, test, user);

    }
}
